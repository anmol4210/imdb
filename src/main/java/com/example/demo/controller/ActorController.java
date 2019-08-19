package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ActorDto;
import com.example.demo.service.ActorService;

@RestController
@CrossOrigin
public class ActorController  {

	
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/actor/all")
	public List<ActorDto> getAllActors() {
		return actorService.getAllActors();
	}
		
}
