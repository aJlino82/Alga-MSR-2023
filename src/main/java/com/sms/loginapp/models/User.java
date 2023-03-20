package com.sms.loginapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 128)
    private String name;
    @Size(max = 128)
    private String email;

    @PastOrPresent(message = "A data de nascimento não pode ser maior que a data atual.")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime bDate;
    @Size(max = 20)
    private String phone;

    public User() {
        super();
    }

    public User(Long id, String name, String email, LocalDateTime bDate, String phone) {
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

    public LocalDateTime getbDate() {
        return bDate;
    }

    public void setbDate(LocalDateTime bDate) {
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
