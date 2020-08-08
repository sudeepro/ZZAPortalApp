package com.sudeep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudeep.entity.SsnEntity;

public interface SsnRepository extends JpaRepository<SsnEntity, String> {

	public Optional<SsnEntity> findById(Long id);

}
