package com.example.demo.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.dto.ActorDto;
import com.example.demo.dto.MovieDto;
import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.model.Producer;

public class ConvertObject {

	public static MovieDto movie2moviedto(Movie movie) {
		MovieDto movieDto  = new MovieDto();
		
		movieDto.setMovieId(movie.getId());
		movieDto.setMovieName(movie.getName());
		movieDto.setMoviePlot(movie.getPlot());
		movieDto.setMovieYor(movie.getYor());
		movieDto.setProducerId(movie.getProducer().getId());
		movieDto.setProducerName(movie.getProducer().getName());
		movieDto.setProducerBio(movie.getProducer().getBio());
		movieDto.setProducerDob(movie.getProducer().getDob());
		movieDto.setProducerSex(movie.getProducer().getSex());
		
		
		List<ActorDto> actorDtos = new ArrayList<ActorDto>();
		
		if(movie.getActors()!= null) {
		List<Actor> actors =  movie.getActors().stream().collect(Collectors.toList());
		for(Actor actor:actors) {
			ActorDto actorDto = new ActorDto();
			actorDto.setActorName(actor.getName());
			actorDto.setActorId(actor.getId());
			actorDto.setActorBio(actor.getBio());
			actorDto.setActorDob(actor.getDob());
			actorDto.setActorSex(actor.getSex());
			actorDtos.add(actorDto);
		}
		}
		movieDto.setActors(actorDtos);
		
		return movieDto;
	}
	
	public static void moviedto2movie(MovieDto movieDto,Movie movie) {
//		Movie movie = new Movie();
		
		Producer producer = null;

		if (movieDto.getProducerName() != null) {
			producer = new Producer();
			producer.setName(movieDto.getProducerName());
			producer.setBio(movieDto.getProducerBio());
			producer.setDob(movieDto.getProducerDob());
			producer.setSex(movieDto.getProducerSex());
			producer.setId(movieDto.getProducerId());

		}

		List<Actor> actorAl = new ArrayList<Actor>();

		if (movieDto.getActors().size() > 0) {

			List<ActorDto> actors = movieDto.getActors();

			for (ActorDto act : actors) {
				if (act.getActorName() != null) {

					Actor actor = null;
					actor = new Actor();
					actor.setName(act.getActorName());
					actor.setBio(act.getActorBio());
					actor.setDob(act.getActorDob());
					actor.setSex(act.getActorSex());
					actor.setId(act.getActorId());
					actorAl.add(actor);
				}
			}

		}

		Set<Actor> hSet = new HashSet<Actor>(actorAl);
		
		movie.setProducer(producer);
		movie.setActors(hSet);
		movie.setName(movieDto.getMovieName());
		movie.setId(movieDto.getMovieId());
		movie.setPlot(movieDto.getMoviePlot());
		movie.setYor(movieDto.getMovieYor());
		
//		return movie;
	}
}
