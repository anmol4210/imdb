package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="producer")
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=true)
	private int id;
	
	@Column(name="name",unique=true,nullable=true)
	private String name;
	
	@Column(name="sex",unique=true,nullable=true)
	private String sex;
	
	@Column(name="dob",unique=true,nullable=true)
	private String dob;
	
	@Column(name="bio",unique=true,nullable=true)
	private String bio;
	
	
	@OneToMany(mappedBy="producer", cascade = CascadeType.ALL)    
	private List<Movie> movies = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
