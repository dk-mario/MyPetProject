package ru.sberbank.jpafinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.jpafinalproject.entity.Customer;
import ru.sberbank.jpafinalproject.entity.Order;
import ru.sberbank.jpafinalproject.entity.Specialist;
import ru.sberbank.jpafinalproject.entity.User;
import ru.sberbank.jpafinalproject.repository.OrderRepository;
import ru.sberbank.jpafinalproject.service.CustomerService;
import ru.sberbank.jpafinalproject.service.SpecialistService;
import ru.sberbank.jpafinalproject.service.UserService;

@Controller
public class SpecialiatController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/specialist")
    public String hello(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByLogin(userDetails.getUsername());
        model.addAttribute("name", user.getName());
        return "welcome_specialist";
    }

    @RequestMapping("/specialist/worksheet")
    public String showWorkSheet(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByLogin(userDetails.getUsername());
        model.addAttribute("user", user);

        return "spec_worksheet";
    }

    @RequestMapping(value = "/specialist/edit")
    public String editform(Model model) {
        model.addAttribute("user", new User());

        return "spec_edit_form";
    }

    @RequestMapping(value = "/specialist/edit", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute("user") User editedUser, @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findUserByLogin(userDetails.getUsername());

        System.out.println(editedUser);

        user.setName(editedUser.getName());
        user.setCity(editedUser.getCity());
        user.setBio(editedUser.getBio());
        user.setLogin(editedUser.getLogin());

        userService.update(user);

        model.addAttribute("user", user);

        return "redirect:/";
    }

    @RequestMapping(value = "/specialist/offers")
    public String addOffers(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findUserByLogin(userDetails.getUsername());

        Specialist specialist = specialistService.getSpecialistByUserId(user.getId());

        model.addAttribute("orders", specialist.getOffered());

        return "spec_offers";
    }


    @RequestMapping(value = "/specialist/order/{id}")
    public String showOffer(Model model, @PathVariable int id) {
        Order order = customerService.findOrderById((long) id);

        model.addAttribute("order", order);
        return "spec_order";
    }

    @RequestMapping(value = "/specialist/customer/{id}")
    public String showCustomerInfo(Model model, @PathVariable int id) {
        Customer customer = customerService.findCustomerById((long) id);

        User customerUser = customer.getUser();

        model.addAttribute("user", customerUser);

        return "spec_customer_info";
    }

    @RequestMapping(value = "/specialist/accept/{id}")
    public String accept(@AuthenticationPrincipal UserDetails userDetails, @PathVariable int id) {
        User user = userService.findUserByLogin(userDetails.getUsername());

        Specialist specialist = specialistService.getSpecialistByUserId(user.getId());

        Order order = orderRepository.getById((long) id);
        specialist.getInWork().add(order);
        order.setInWork(specialist);
        order.getOfferedSpecialist().clear();

        specialistService.save(specialist);
        orderRepository.save(order);

        return "redirect:/specialist";
    }

}
