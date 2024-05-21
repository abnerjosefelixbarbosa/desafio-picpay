package com.org.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}