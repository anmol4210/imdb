package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.demo.dao.ActorDao;
import com.example.demo.dto.ActorDto;
import com.example.demo.model.Actor;
import com.example.demo.utils.HibernateUtils;

public class ActorDaoImpl implements ActorDao {

	@Override
	public List<ActorDto> getAllActors() {
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM Actor as actor");
		
		List<Actor> actorsList = query.list();
		List<ActorDto> actorsDtoList = new ArrayList<>();
		
		for(Actor actor:actorsList) {
			
			ActorDto actorDto = new ActorDto();
			actorDto.setActorBio(actor.getBio());
			actorDto.setActorDob(actor.getDob());
			actorDto.setActorId(actor.getId());
			actorDto.setActorName(actor.getName());
			actorDto.setActorSex(actor.getSex());
			
			actorsDtoList.add(actorDto);
		}
		return actorsDtoList;
	}

}
