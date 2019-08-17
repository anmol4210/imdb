package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MovieDao;
import com.example.demo.dto.MovieDto;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Component
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	
	
	@Override
	public List<MovieDto> getAllMovies() {
		
		return movieDao.getAllMovies();
	}

	
	
	
	@Override
	public Object addMovie(MovieDto movie) {
		
		return movieDao.addMovie(movie);
	}




	@Override
	public MovieDto updateMovie(MovieDto movie) {
		
		return movieDao.updateMovie(movie);
	}

}
