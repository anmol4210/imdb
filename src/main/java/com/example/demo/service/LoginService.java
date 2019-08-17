package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;

public interface LoginService {
	public ResponseDto authenticateUser(LoginDto admin);
}
