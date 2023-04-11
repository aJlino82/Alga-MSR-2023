package com.sms.loginapp.controllers;

import com.sms.loginapp.models.User;
import com.sms.loginapp.models.documents.ContratoA;
import com.sms.loginapp.models.documents.ContratoEmLoteA;
import com.sms.loginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/frase")
public class PdfButtController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public void olamundo(@PathVariable("id") long id) {

        User user = userService.findById(id);
        String name = user.getName();

        ContratoA contratoA = new ContratoA();
        contratoA.print(name);
    }

    @GetMapping("/list")
    public void getList() {

        List<User> userList = userService.findAll();
        System.out.println("Otamanho da lista é: " + userList.size());

        int n = 0;

        for (int i = 0; i < userList.size(); i++) {
            n = i;
            ContratoEmLoteA contratoEmLoteA = new ContratoEmLoteA();
            contratoEmLoteA.printList(userList, n);
            System.out.println("Valor de i :" + i);

        }


    }
}
