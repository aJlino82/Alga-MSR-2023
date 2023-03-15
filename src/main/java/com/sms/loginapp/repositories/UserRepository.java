package com.sms.loginapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.loginapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameContaining(String name);

}
