package com.lavacash.app.controller;

import com.lavacash.app.domain.User;

import com.lavacash.app.services.UserServices;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/account")
public class UserController {

    @Autowired
    private UserServices userServices;
    //mostrar vistas
    
    @GetMapping("/register")
    public String viewRegister(Model model){
        model.addAttribute("user", new User());
        return "user/autentication/form_register_user";
    }

    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("user", new User());
        return "user/autentication/form_login_user";
    }

    //procesar datos

    @PostMapping("/save")
    public String saveUser(@Validated User user){
        userServices.add(user);
        return "user/autentication/succes_register";
    }

    @PostMapping("/ingresar")
    public String login(@Validated User user, Model model, HttpSession session){
        User u = userServices.getUserVerify(user.getCorreo(), user.getContrasena());
        if(u.getRol().equalsIgnoreCase("CLIENT")){
            model.addAttribute("client", u);
            session.setAttribute("csession", u);
            return  "user/client/index";
        }
        return "user/autentication/login";
    }
}
