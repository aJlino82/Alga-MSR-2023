package com.sms.loginapp.models.documents;

import com.sms.loginapp.models.User;

import java.util.List;

public interface Contrato {

    public void setHead();

    public void setBody();

    public void setFoot();

    public void print(String nome);

    public void printList(List<User> userList, int n);

}
