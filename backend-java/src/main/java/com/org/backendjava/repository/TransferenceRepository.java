package com.org.backendjava.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.Transference;
import com.org.backendjava.model.entity.User;

@Repository
public interface TransferenceRepository extends JpaRepository<Transference, Long> {
	Page<Transference> findAllByPayer(User user, Pageable pageable);
}