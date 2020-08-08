package com.sudeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudeep.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Long> {

	@Query(value = "SELECT S.STATE_NAME  FROM STATE_MASTER s", nativeQuery = true)
	public List<String> findAllState();

}
