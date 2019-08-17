package com.example.demo.dto;

import java.util.List;


public class MovieDto {
	
	public String movieName;
	public String movieYor;
	public String moviePlot;
	
	public int movieId;
	
	public String producerName;
	public String producerSex;
	public String producerDob;
	public String producerBio;
	public int producerId;
	
	public List<ActorDto> actors;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public int getProducerId() {
		return producerId;
	}
	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}
	
	
	
	public List<ActorDto> getActors() {
		return actors;
	}
	public void setActors(List<ActorDto> actors) {
		this.actors = actors;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieYor() {
		return movieYor;
	}
	public void setMovieYor(String movieYor) {
		this.movieYor = movieYor;
	}
	public String getMoviePlot() {
		return moviePlot;
	}
	public void setMoviePlot(String moviePlot) {
		this.moviePlot = moviePlot;
	}
		public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getProducerSex() {
		return producerSex;
	}
	public void setProducerSex(String producerSex) {
		this.producerSex = producerSex;
	}
	public String getProducerDob() {
		return producerDob;
	}
	public void setProducerDob(String producerDob) {
		this.producerDob = producerDob;
	}
	public String getProducerBio() {
		return producerBio;
	}
	public void setProducerBio(String producerBio) {
		this.producerBio = producerBio;
	}
	
}
