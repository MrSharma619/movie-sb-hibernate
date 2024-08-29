package com.example.movie_sb_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.NoArgsConstructor;


import java.util.List;


@NoArgsConstructor
public class MovieService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("movieCatalog");
    private final EntityManager em = emf.createEntityManager();

    public void saveMovie(){

        em.getTransaction().begin();

        Movie movie = new Movie(
                1L,
                "Thor",
                2011,
                "English"
        );

        em.persist(movie);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public Movie getMovieById(Long movieId){
        return em.find(Movie.class, movieId);
    }

    public List<?> getAllMovies(){
        //table name here should be same as classname not actual table name in db
        return em.createQuery("SELECT m from Movie m").getResultList();
    }

    public void save3Movies(){
        em.getTransaction().begin();

        Movie movie1 = new Movie(
                2L,
                "Ironman",
                2008,
                "English"
        );

        Movie movie2 = new Movie(
                3L,
                "hulk",
                2008,
                "English"
        );

        Movie movie3 = new Movie(
                4L,
                "avengers",
                2012,
                "English"
        );

        em.persist(movie1);
        em.persist(movie2);
        em.persist(movie3);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
