package io.JordanDev.server.controller;

import io.JordanDev.server.model.User;
import io.JordanDev.server.repository.UserRepo;
import io.JordanDev.server.service.UserService;
import io.JordanDev.server.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutUser (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }

//    @GetMapping("/createUser")
//    public String createUser(Model model){
//        model.addAttribute("user", new User());
//        return "newUserRegistration";
//    }

    @GetMapping("/newUserRegistration")
    public String newUserRegistration(Model model){
        User user = new User();
        model.addAttribute("newUser", user);
        return "newUserRegistration";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "redirect:login";

    }

}
