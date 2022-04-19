package ru.sberbank.jpafinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.jpafinalproject.entity.Specialist;
import ru.sberbank.jpafinalproject.entity.User;
import ru.sberbank.jpafinalproject.service.SpecialistService;
import ru.sberbank.jpafinalproject.service.UserService;

import static ru.sberbank.jpafinalproject.entity.RoleType.SPECIALIST;

@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    @Autowired
    private SpecialistService specialistService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm) {

        service.create(userForm);
        System.out.println(userForm);
        if (userForm.getRoles().iterator().next().getName().equals(SPECIALIST.getName())) {
            Specialist specialist = new Specialist(userForm);
            specialistService.save(specialist);
        }

        return "redirect:/login";
    }

}
