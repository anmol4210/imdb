package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false)
	private int id;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="year",unique=true,nullable=false)
	private String yor;
	
	@Column(name="plot",unique=true,nullable=false)
	private String plot;
	
	@Column(name="poster")
	private char[] poster;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movies_actor", 
			  joinColumns = @JoinColumn(name = "movie_id"), 
			  inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> actors;
	
	
	@ManyToOne
    @JoinColumn(name="producerId")
	private Producer producer;

	
	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	
	
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

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

	public String getYor() {
		return yor;
	}

	public void setYor(String yor) {
		this.yor = yor;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public char[] getPoster() {
		return poster;
	}

	public void setPoster(char[] poster) {
		this.poster = poster;
	}

	
	}
