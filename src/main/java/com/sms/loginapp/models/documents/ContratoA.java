package com.sms.loginapp.models.documents;

import com.sms.loginapp.models.User;

import java.util.List;

public class ContratoA implements Contrato {

    @Override
    public void setHead() {

    }

    @Override
    public void setBody() {

    }

    @Override
    public void setFoot() {

    }

    @Override
    public void print(String nome) {
        System.out.println("Olá mundo! " + nome);
    }

    @Override
    public void printList(List<User> userList, int n) {

    }

    @Override
    public void compactFiles(String arqSaida, String arqEntrada) {

    }
}
