package com.j0llysnowman.movies.dao;

import com.google.common.base.Preconditions;
import com.j0llysnowman.movies.domain.Person;

import java.util.List;

/**
 * Created by david on 6/11/16.
 */
public class MemoryPersonDao extends MemoryEntityDao<Person> implements PersonDao {

    @Override
    public List<Person> findByName(String name) {
        Preconditions.checkNotNull(name);

        List<Person> people = getAll();
        people.removeIf(person -> !name.equals(person.getName()));

        return people;
    }
}
