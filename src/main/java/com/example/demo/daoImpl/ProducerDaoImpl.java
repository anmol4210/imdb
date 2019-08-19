package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.demo.dao.ProducerDao;
import com.example.demo.dto.ActorDto;
import com.example.demo.dto.ProducerDto;
import com.example.demo.model.Actor;
import com.example.demo.model.Producer;
import com.example.demo.utils.HibernateUtils;

public class ProducerDaoImpl implements ProducerDao{

	@Override
	public List<ProducerDto> getAllProducers() {
		
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM Producer as producer");
		
		List<Producer> producersList = query.list();
		List<ProducerDto> producersDtoList = new ArrayList<>();
		
		for(Producer producer:producersList) {
			
			ProducerDto producerDto = new ProducerDto();
			producerDto.setProducerBio(producer.getBio());
			producerDto.setProducerDob(producer.getDob());
			producerDto.setProducerId(producer.getId());
			producerDto.setProducerName(producer.getName());
			producerDto.setProducerSex(producer.getSex());
			
			producersDtoList.add(producerDto);
		}
		return producersDtoList;
	}

}
