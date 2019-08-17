package com.example.demo.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="actor")
public class Actor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private int id;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="sex",unique=true,nullable=false)
	private String sex;
	
	@Column(name="dob",unique=true,nullable=false)
	private String dob;
	
	@Column(name="bio",unique=true,nullable=false)
	private String bio;

	
	@ManyToMany(mappedBy = "actors")
	private Set<Movie> movies;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
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
