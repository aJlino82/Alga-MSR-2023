package com.sms.loginapp.controllers;


import com.sms.loginapp.models.User;
import com.sms.loginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MvcUserController {

    @Autowired
    UserService userService;

    public ModelAndView getIndex(Model model) {
        ModelAndView mv = new ModelAndView("index");
        User user = new User();
        model.addAttribute(user);
        return mv;
    }


    public

}
