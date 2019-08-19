package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ProducerDao;
import com.example.demo.dto.ProducerDto;
import com.example.demo.service.ProducerService;

@Component
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerDao producerDao;
	
	@Override
	public List<ProducerDto> getAllProducers() {
		
		return producerDao.getAllProducers();
	}

}
