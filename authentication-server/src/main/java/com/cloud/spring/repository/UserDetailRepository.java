package com.cloud.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.spring.model.User;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String name);

}
