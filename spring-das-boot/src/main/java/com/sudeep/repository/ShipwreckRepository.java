package com.sudeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudeep.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck	, Long> {

}
