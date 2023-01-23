package com.hotelmanagement.user.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
