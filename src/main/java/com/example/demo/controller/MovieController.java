package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieDto;
import com.example.demo.service.MovieService;

@RestController
@CrossOrigin
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movie/all")
	public List<MovieDto> getAllMovies() {
		
		System.out.println("*******welcome movie controller********");
		
		
		return movieService.getAllMovies();
//		return loginService.authenticateUser(user);
		
	}
	
	@PostMapping("/movie/add")
	public Object addMovie(@RequestBody MovieDto movie) {
		
		System.out.println("*******add movie controller********");
		
		
		return movieService.addMovie(movie);

	}
	
	@PostMapping("/movie/update")
	public Object updateMovie(@RequestBody MovieDto movie) {
		
		System.out.println("*******update movie controller********");
		
		
		return movieService.updateMovie(movie);

	}
	

}
