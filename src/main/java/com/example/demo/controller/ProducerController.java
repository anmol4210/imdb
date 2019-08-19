package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProducerDto;
import com.example.demo.service.ProducerService;

@RestController
@CrossOrigin
public class ProducerController {

	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/producer/all")
	public List<ProducerDto> getAllProducerss() {
		
		return producerService.getAllProducers();
	}
		
}

