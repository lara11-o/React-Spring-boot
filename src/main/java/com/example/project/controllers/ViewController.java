package com.example.project.controllers;

import com.example.project.DAO.User.UserDAO;
import com.example.project.DTO.request.LoginRequest;
import com.example.project.Entity.User;
import com.example.project.Exception.OpportunityException.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ViewController {
UserDAO userDAO;
@Autowired
    public ViewController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String home(Model model){
        System.out.println("in view controller");
        return "login";
    }

    @PostMapping("/login")
    public String log(LoginRequest userLoginreq){
        System.out.println(",,,,,,,LOGIN,Cont,,,,,,,");
        User user = userDAO.getByEmail(userLoginreq.getEmail());
        System.out.println(user);
        System.out.println(user.toString());

        if (user == null) {
            throw new NotFoundException("User not found with email: " + userLoginreq.getEmail());
        }

        if (!user.getPassword().equals(userLoginreq.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return "redirect:users";
    }
    @GetMapping("/users")
   // @PreAuthorize("hasRole('ADMIN')")
    public String users(Model model){
        List<User> users = userDAO.findAllUsers();
        System.out.println(users);
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/register")
    public String register(Model model){
        System.out.println("in view controller");
        return "register";
    }

}
