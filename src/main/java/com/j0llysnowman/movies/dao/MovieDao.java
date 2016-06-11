package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Movie;

import java.util.List;

/**
 * Created by david on 6/11/16.
 */
public interface MovieDao extends EntityDao<Movie> {

    List<Movie> findByTitle(String title);

    List<Movie> findByDirector(String director);

    List<Movie> findByProducer(String producer);

    List<Movie> findByCastMember(String castMember);
}
