package com.sudeep.controller;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sudeep.model.UserSsn;
import com.sudeep.service.SsnService;

@RestController
public class SsnUserResource {

	@Autowired
	private SsnService service;

	@PostMapping(path = "/register", consumes = "application/json")
	public ResponseEntity<?> saveUser(@RequestBody UserSsn user) {
		if (user != null && !"null".equalsIgnoreCase(user.getFirstName())
				&& !"null".equalsIgnoreCase(user.getLastName()) && !"null".equalsIgnoreCase(user.getGender())
				&& !"null".equalsIgnoreCase(user.getState()) && StringUtils.isNotBlank(user.getFirstName())
				&& StringUtils.isNotBlank(user.getLastName()) && StringUtils.isNotBlank(user.getGender())
				&& StringUtils.isNotBlank(user.getState())) {

			UserSsn savedUser = service.saveUser(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedUser.getSsnId()).toUri();
			return ResponseEntity.created(location).build();
		} else {

			return ResponseEntity.badRequest().build();
		}

	}

}