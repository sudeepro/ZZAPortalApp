package com.sudeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudeep.entity.SsnEntity;

public interface SsnRepository extends JpaRepository<SsnEntity, Long> {

	// public String findStateBySsnId(Long id);

}
