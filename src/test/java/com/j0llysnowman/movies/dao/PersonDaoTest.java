package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by david on 6/11/16.
 */
public abstract class PersonDaoTest extends BaseEntityDaoTest<Person> {

    @Test
    public void testFindByName() {
        List<Person> peopleWithSameName = Arrays.asList(
                generateEntity()
                , generateEntity()
                , generateEntity()
        );

        for (Person person : peopleWithSameName) {
            person.setName("same name");
            getDao().create(person);
        }

        getDao().create(generateEntity());

        List<Person> peopleFromDb = ((PersonDao) getDao()).findByName("same name");

        assertNotNull(peopleFromDb);
        assertEquals(3, peopleFromDb.size());

        for (Person person : peopleWithSameName) {
            assertTrue(peopleFromDb.contains(person));
        }
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