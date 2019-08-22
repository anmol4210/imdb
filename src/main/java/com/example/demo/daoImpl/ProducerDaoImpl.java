package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ProducerDao;
import com.example.demo.dto.ProducerDto;
import com.example.demo.model.Producer;
import com.example.demo.utils.HibernateUtils;

@Component
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
		session.close();
		return producersDtoList;
	}
   
	@Override
	public ProducerDto addProducer(ProducerDto producerDto) {
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
//		
		Producer producer = new Producer();
		producer.setName(producerDto.getProducerName());
		producer.setBio(producerDto.getProducerBio());
		producer.setDob(producerDto.getProducerDob());
		producer.setSex(producerDto.getProducerSex());

		int prodId =  (int) session.save(producer); 
		if (prodId != 0) {
			
			session.getTransaction().commit();
			session.close();
			
			producerDto.setProducerId(prodId);
			
			
			
			return producerDto;
		}
		session.close();
		return null;
	}

}
