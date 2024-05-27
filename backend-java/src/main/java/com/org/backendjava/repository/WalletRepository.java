package com.org.backendjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
	Optional<Wallet> findByUser(User user);
}