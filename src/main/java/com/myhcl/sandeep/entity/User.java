package com.myhcl.sandeep.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "user_tab")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String fname;
	private String lname;
	private Double salary;
	@Transient
	private String captcha;
	@Transient
	private String hidden;
	@Transient
	private String image;

}
