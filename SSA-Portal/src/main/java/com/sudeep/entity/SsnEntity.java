package com.sudeep.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SSN_MASTER")
@Data
public class SsnEntity {
	@Id
	@GeneratedValue
	@Column(name = "SSN_ID")
	private Long ssnId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DOB")
	private LocalDate dob;
	@Column(name = "STATE")
	private String state;

}
