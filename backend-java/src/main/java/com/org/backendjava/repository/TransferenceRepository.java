package com.org.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.model.entity.Transference;

@Repository
public interface TransferenceRepository extends JpaRepository<Transference, Long> {

}