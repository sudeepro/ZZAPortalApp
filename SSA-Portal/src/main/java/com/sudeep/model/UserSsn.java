package com.sudeep.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserSsn {

	private String ssnId;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate dob;
	private String state;

}
