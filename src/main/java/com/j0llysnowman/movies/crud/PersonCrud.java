package com.j0llysnowman.movies.crud;

import com.j0llysnowman.movies.domain.Person;

/**
 * Created by david on 6/11/16.
 */
public interface PersonCrud extends EntityCrud<Person> {

    Person findByName(String name);
}
