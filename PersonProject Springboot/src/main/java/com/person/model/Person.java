package com.person.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="person")
public class Person implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Column(name = "full_name")
	@Size(min = 2, message = "Full Name must have at least 2 characters")
	private String fullName;
	
	@NotNull
	@Column(name = "phone_number", length=10)
	@Size(min = 2, message = "Phone Number must have minimum of 2 charachters and a maximum of 10 characters")
	private String phoneNumber;
	
	@NotNull
	@Column(name = "id_number", length=13)
	@Size(min = 2, message="ID number must have minimum of 2 charachters and a maximum of 13 characters")
	private String idNumber;
	
	public Person() {
		
	}

	public Person(int id,String fullName, String phoneNumber,String idNumber) {
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	

}
