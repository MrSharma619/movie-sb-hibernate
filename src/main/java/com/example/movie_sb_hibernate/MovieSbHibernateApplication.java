package com.example.movie_sb_hibernate;


import java.util.List;

public class MovieSbHibernateApplication {

	public static void main(String[] args) {

		MovieService service = new MovieService();

		//service.saveMovie();

		//System.out.println(service.getMovieById(1L));

		//service.save3Movies();

		List<?> movies = service.getAllMovies();

		for(Object movie : movies){
			System.out.println(movie);
		}

	}

}
