package com.sms.loginapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(unique = true, nullable = true, updatable = false)
    @NotBlank(message = "O campo não pode estar em branco.")
    @Size(message = "O email deve conter entre 5 e 64 letras.", min = 5, max = 64)
    private String email;

    @Column(name = "password_hash", unique = true)
    private String password;

    private Perfil perfil;

    @UpdateTimestamp
    private Date lastLogin;
    @Transient
    private String passwordRepeat;

    private Date bDate;
    @Size(message = "O telefone deve conter o dd e o numero.", min = 8, max = 20)
    private String phone;

    public String getPassword() {
        return password;
    }

    public User() {
        super();
    }

    public User(Long id, String name, String email, String password, Perfil perfil, Date lastLogin, String passwordRepeat, Date bDate, String phone) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", perfil=" + perfil +
                ", lastLogin=" + lastLogin +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                ", bDate=" + bDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
