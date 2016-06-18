package com.j0llysnowman.movies.dao;

import com.google.common.base.Preconditions;
import com.j0llysnowman.movies.domain.Person;

import java.util.List;

/**
 * Created by david on 6/11/16.
 */
public class MemoryPersonDao extends MemoryEntityDao<Person> implements PersonDao {

    @Override
    public Person findByName(String name) {
        Preconditions.checkNotNull(name);

        List<Person> people = getAll();
        for (Person person : people) {
            if (name.equals(person.getName())) {
                return person;
            }
        }

        return null;
    }
}
