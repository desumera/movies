package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Person;

import java.util.List;

/**
 * Created by david on 6/11/16.
 */
public interface PersonDao extends EntityDao<Person> {

    List<Person> findByName(String name);
}
