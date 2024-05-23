package com.org.backendjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUser(User user);
}
