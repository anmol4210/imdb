package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MovieDao;
import com.example.demo.dao.ProducerDao;
import com.example.demo.dto.ActorDto;
import com.example.demo.dto.MovieDto;
import com.example.demo.dto.ProducerDto;
import com.example.demo.dto.ResponseData;
import com.example.demo.dto.ResponseDto;
import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.model.Producer;
import com.example.demo.utils.ConvertObject;
import com.example.demo.utils.HibernateUtils;

@Component
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private ProducerDao producerDao;
//	private Session session;

	public MovieDaoImpl() {

//		this.session = HibernateUtils.createSession();
//		this.session.beginTransaction();

	}

	@Override
	public List<MovieDto> getAllMovies() {
		
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM Movie as movies");
		
		System.out.println("*****get all movies*********");
		List<Movie> moviesList = query.list();
		
		List<MovieDto> movieDtos = new ArrayList<>();
		for(Movie movie:moviesList) {
			MovieDto movieDto =ConvertObject.movie2moviedto(movie);
			movieDtos.add(movieDto);
			
//			movieDto.setMovieId(movie.getId());
			System.out.println("Movie Name: "+movie.getName());
			System.out.println("Movie Id: "+movie.getId());
			System.out.println("Movie Plot: "+movie.getPlot());
			System.out.println(movie.getYor());
			System.out.println("Producer Name: "+movie.getProducer().getName());
			System.out.println("Producer Sex: "+movie.getProducer().getSex());
			System.out.println("Producer Id: "+movie.getProducer().getId());
			
			for(Actor actor:movie.getActors()) {
				System.out.println("Actor Name: "+actor.getName());
				System.out.println("Actor Id: "+actor.getId());
				
			}
			System.out.println("*************************8");
		}
		
		session.close();
		return movieDtos;
//		return moviesList;
	}

	@Override
	public String addMovie(MovieDto movieDto) {
		
//		System.out.println("Movie Name: "+movieDto.getMovieName());
//		System.out.println("Movie Id: "+movieDto.getMovieId());
//		System.out.println("Producer Name: "+movieDto.getProducerName());
////		System.out.println("Producer Sex: "+movie.getProducer().getSex());
//		System.out.println("Producer Id: "+movieDto.getProducerId());
//		
//		for(ActorDto actor:movieDto.getActors()) {
//			System.out.println("Actor Name: "+actor.getActorName());
//			System.out.println("Actor Id: "+actor.getActorId());
//			
//		}
		
		
		System.out.println("add movie dao");
		ResponseDto responseDto = new ResponseDto();

		Movie movie = new Movie();
		
//System.out.println(movieDto.getProducerId());
		
if((movieDto.getProducerId()==0) ) {
			ProducerDto producerDto = new ProducerDto();
			producerDto.setProducerName(movieDto.getProducerName());
			producerDto.setProducerBio(movieDto.getProducerBio());
			producerDto.setProducerDob(movieDto.getProducerDob());
			producerDto.setProducerSex(movieDto.getProducerSex());
			
			producerDao.addProducer(producerDto);
			
			System.out.println(producerDto.getProducerName());
			System.out.println(producerDto.getProducerId());
		
			movieDto.setProducerId(producerDto.getProducerId());
		}
		ConvertObject.moviedto2movie(movieDto,movie);

		Session session = HibernateUtils.createSession();
		session.beginTransaction();
		
		int movId = (int) session.save(movie);
		if (movId != 0) {

			ResponseData responseData = new ResponseData();
			responseData.setToken("");
			responseDto.setStatus(200);
			responseDto.setData(responseData);

			session.getTransaction().commit();
			
			session.close();
			return "200";
		}

		else {

			ResponseData responseData = new ResponseData();
			responseDto.setStatus(403);
			responseDto.setData(responseData);
			responseDto.setMessage("password mismatch");
			session.close();
			return "403";
		}

	}

	@Override
	public MovieDto updateMovie(MovieDto movieDto) {
		
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
		
		Object object = session.load(Movie.class,new Integer(""+movieDto.getMovieId()));
		
		Movie movie=(Movie) object;
		
		Producer producer = movie.getProducer();
		producer.setName(movieDto.getProducerName());
		producer.setSex(movieDto.getProducerSex());
		producer.setDob(movieDto.getProducerDob());
		producer.setBio(movieDto.getProducerBio());
		
		
		List<ActorDto> actorDtos = movieDto.getActors();
		List<Actor> actors = new ArrayList<Actor>();//movie.getActors().stream().collect(Collectors.toList());
		
		for(ActorDto actorDto: actorDtos) {
			Actor actor = new Actor();
			actor.setName(actorDto.getActorName());
			actor.setBio(actorDto.getActorBio());
			actor.setDob(actorDto.getActorDob());
			actor.setSex(actorDto.getActorSex());
			actor.setId(actorDto.getActorId());
			actors.add(actor);
		}
		movie.setActors(new HashSet<Actor>(actors));
		
		movie.setName(movieDto.getMovieName());
		movie.setPlot(movieDto.getMoviePlot());
		movie.setYor(movieDto.getMovieYor());
		movie.setProducer(producer);
		
		
		session.getTransaction().commit();
		
		int movieId=(movieDto.getMovieId());
		Query query = session.createQuery("FROM Movie as movie where movie.id=:id");
		query.setParameter("id", movieId);
	
		List<Movie> movies= query.list();
		
		  
		
		if (movies.size()>0  ) {
			movieDto =  ConvertObject.movie2moviedto(movies.get(0));
		}
		session.close();
		
		return movieDto;
	}

}
