package com.org.backendjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmailOrDocmentOrPassword(String email, String docment, String password);

	Optional<User> findByIdOrDocment(Long id, String docment);
}