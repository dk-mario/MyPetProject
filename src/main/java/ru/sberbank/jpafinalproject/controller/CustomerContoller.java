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
import ru.sberbank.jpafinalproject.model.Subject;
import ru.sberbank.jpafinalproject.entity.User;
import ru.sberbank.jpafinalproject.service.CustomerService;
import ru.sberbank.jpafinalproject.service.SpecialistService;
import ru.sberbank.jpafinalproject.service.UserService;

import java.util.List;

@Controller
public class CustomerContoller {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SpecialistService specialistService;

    @RequestMapping("/customer")
    public String hello(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByLogin(userDetails.getUsername());

        model.addAttribute("name", user.getName());

        return "welcome_customer";
    }

    @RequestMapping(value = "/customer/addorder", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());

        return "customer_add_order";
    }

    @RequestMapping(value = "/customer/addorder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") Order order, @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findUserByLogin(userDetails.getUsername());
        Customer customer = customerService.findCustomerByUserId(user.getId());
        if (customer == null) {
            customer = new Customer(user);
            customerService.saveCustomer(customer);
        }

        order.setCustomer(customer);

        customerService.saveOrder(order);

        return "redirect:/customer";
    }

    @RequestMapping(value = "/customer/orders")
    public String showOrders(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByLogin(userDetails.getUsername());
        System.out.println(user);
        List<Order> orders = customerService.findAllOrdersByUserId(user.getId());

        model.addAttribute("orders", orders);

        return "customer_orders";
    }

    @RequestMapping(value = "/customer/order/{id}")
    public String showOrder(@PathVariable int id, Model model) {
        long orderId = id;
        Order order = customerService.findOrderById(orderId);

        model.addAttribute("order", order);

        model.addAttribute("subject", new Subject());

        return "customer_order";

    }

    @RequestMapping(value = "/customer/order/{id}", method = RequestMethod.POST)
    public String showSpecialist(Model model, @ModelAttribute Subject subject, @PathVariable int id) {
        long orderId = id;
        Order order = customerService.findOrderById(orderId);

        model.addAttribute("order", order);

        List<Specialist> specialists = specialistService.findSpecialistByBioContains(subject.getSub());
        model.addAttribute("specialists", specialists);

        return "customer_order";
    }

    @RequestMapping(value = "/customer/offer/{orderId}/{specId}")
    public String sendOffer(@PathVariable int orderId, @PathVariable int specId) {
        Order order = customerService.findOrderById((long) orderId);
        Specialist specialist = specialistService.findSpecialistById((long) specId);
        order.addOfferedSpecialist(specialist);
        specialist.addOffer(order);

        customerService.saveOrder(order);
        specialistService.save(specialist);

        return "redirect:/customer";
    }


    @RequestMapping(value = "/customer/offers")
    public String showOffers(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByLogin(userDetails.getUsername());

        model.addAttribute("user", user);

        return "customer_offers";
    }

    @RequestMapping(value = "/customer/spec/{id}")
    public String showUser(@PathVariable int id, Model model) {

        User user = specialistService.findSpecialistById(id).getUser();

        model.addAttribute("user", user);

        return "customer_user";
    }

}
