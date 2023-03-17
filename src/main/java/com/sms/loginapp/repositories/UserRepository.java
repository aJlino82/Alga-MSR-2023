package com.sms.loginapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.loginapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
