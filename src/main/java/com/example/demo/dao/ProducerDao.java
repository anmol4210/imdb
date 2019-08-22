package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.ProducerDto;
import com.example.demo.model.Producer;



public interface ProducerDao {
	public List<ProducerDto> getAllProducers();
	public ProducerDto addProducer(ProducerDto producer);
}
