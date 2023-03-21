package com.sms.loginapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O campo não pode estar em branco.")
    @Size(message = "O nome deve conter entre 5 e 128 letras.", min = 5, max = 128)
    private String name;
    @NotBlank(message = "O campo não pode estar em branco.")
    @Size(message = "O email deve conter entre 5 e 64 letras.", min = 5, max = 64)
    private String email;

    private Date bDate;
    @Size(message = "O telefone deve conter o dd e o numero.", min = 8, max = 20)
    private String phone;

    public User() {
        super();
    }

    public User(Long id, String name, String email, Date bDate, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.bDate = bDate;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", bDate=" + ", phone=" + phone + "]";
    }

}
