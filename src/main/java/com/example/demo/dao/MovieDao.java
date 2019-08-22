package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.MovieDto;

public interface MovieDao {

	public List<MovieDto> getAllMovies();
	public String addMovie(MovieDto movie);
	public MovieDto updateMovie(MovieDto movie);
}
