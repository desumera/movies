package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Person;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 6/11/16.
 */
public abstract class PersonDaoTest extends BaseEntityDaoTest<Person> {

    @Test
    public void testFindByName() {
        Person person = generateEntity();
        final String name = person.getName();

        getDao().create(person);
        getDao().create(generateEntity());
        getDao().create(generateEntity());

        Person personFromDb = ((PersonDao) getDao()).findByName(name);

        assertEquals(person, personFromDb);
    }

    @Override
    protected Person generateEntity() {
        Person person = new Person();

        person.setName(UUID.randomUUID().toString());

        return person;
    }

    @Override
    protected void updateEntity(Person entity) {
        entity.setName(UUID.randomUUID().toString());
    }
}