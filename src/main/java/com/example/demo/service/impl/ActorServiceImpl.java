package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ActorDao;
import com.example.demo.dto.ActorDto;
import com.example.demo.service.ActorService;

@Component
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao actorDao;
	
	@Override
	public List<ActorDto> getAllActors() {
		// TODO Auto-generated method stub
		return actorDao.getAllActors();
	}

}
