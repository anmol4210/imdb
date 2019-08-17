package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MovieDto;
import com.example.demo.model.Movie;

public interface MovieService {
	
	public List<MovieDto> getAllMovies();
	public Object addMovie(MovieDto movie);
	public MovieDto updateMovie(MovieDto movie);
}
