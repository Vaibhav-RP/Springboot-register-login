package com.example.loginregisterapp.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.loginregisterapp.entity.User;
import com.example.loginregisterapp.service.UserService;


@Controller
public class UserController {

  @Autowired
  private UserService userService;


  @GetMapping("/index")
    public String show() {
        return "index";
  }

  @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
      
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> optionalUser = userService.findUser(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                return "redirect:/users";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }


    @GetMapping("/users")
    public String showUserDetails(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "users";
        } else {
            return "redirect:/login";
        }
    }
}