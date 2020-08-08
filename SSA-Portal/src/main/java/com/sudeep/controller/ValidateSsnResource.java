package com.sudeep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sudeep.exception.SsnNotFoundException;
import com.sudeep.service.SsnServiceImpl;

public class ValidateSsnResource {

	private SsnServiceImpl service;

	@GetMapping("/userSsn/{id}")
	public ResponseEntity<?> retrieveBySsnId(@PathVariable("id") Long id, Model model) {
		if (service.findUser(id) == false)

			throw new SsnNotFoundException("SSN" + id);

		return new ResponseEntity<>("Your SSN is Invalid", HttpStatus.OK);
	}

}
