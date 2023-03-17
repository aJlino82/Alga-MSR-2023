package com.sms.loginapp.controllers;


import com.sms.loginapp.models.User;
import com.sms.loginapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MvcUserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/addView")
    public ModelAndView getCadastro(Model model) {
        ModelAndView mv = new ModelAndView("cadastro");
        User user = new User();
        model.addAttribute("user", user);
        return mv;
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("cadastro");
            System.out.println("Erro ao criar usuário.");
        }
        ModelAndView mv = new ModelAndView("index");
        userService.save(user);
        return mv;
    }

}
