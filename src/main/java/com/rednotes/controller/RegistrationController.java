package com.rednotes.controller;

import com.rednotes.dao.UserRepo;
import com.rednotes.model.Role;
import com.rednotes.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserRepo userRepo;
    public RegistrationController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "login/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.addAttribute("message", "User exists");
            return "login/registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}
