package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.LoginService;


@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login/admin")
	public ResponseDto loginAdmin(@RequestBody LoginDto user) {
		System.out.println("*******welcome login user********");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return loginService.authenticateUser(user);
		
	}
	
	@GetMapping("/login/admin")
	public ResponseDto loginAdmin() {
		System.out.println("*******welcome login user********");
		System.out.println();
		return null;
		
	}
}
