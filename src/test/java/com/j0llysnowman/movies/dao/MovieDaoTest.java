package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.enums.MpaaRating;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.enums.Role;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by david on 6/11/16.
 */
public abstract class MovieDaoTest extends BaseEntityDaoTest<Movie> {

    @Test
    public void testFindByTitle() {
        List<Movie> moviesWithSameTitle = Arrays.asList(
                generateEntity()
                , generateEntity()
                , generateEntity()
        );

        for (Movie movie : moviesWithSameTitle) {
            movie.setTitle("space jam");
            getDao().create(movie);
        }

        getDao().create(generateEntity());

        List<Movie> moviesFromDb = ((MovieDao) getDao()).findByTitle("space jam");

        assertNotNull(moviesFromDb);
        assertEquals(3, moviesFromDb.size());

        for (Movie movie : moviesWithSameTitle) {
            assertTrue(moviesFromDb.contains(movie));
        }
    }

    @Test
    public void testFindByDirector() {
        List<Movie> moviesWithSameDirector = Arrays.asList(
                generateEntity()
                , generateEntity()
                , generateEntity()
        );

        Person director = generatePerson();

        for (Movie movie : moviesWithSameDirector) {
            movie.getStaff().put(director, Collections.singleton(Role.DIRECTOR));
            getDao().create(movie);
        }

        getDao().create(generateEntity());

        List<Movie> moviesFromDb = ((MovieDao) getDao()).findByDirector(director.getName());

        assertNotNull(moviesFromDb);
        assertEquals(3, moviesFromDb.size());

        for (Movie movie : moviesWithSameDirector) {
            assertTrue(moviesFromDb.contains(movie));
        }
    }

    @Test
    public void testFindByProducer() {
        List<Movie> moviesWithSameProducer = Arrays.asList(
                generateEntity()
                , generateEntity()
                , generateEntity()
        );

        Person producer = generatePerson();

        for (Movie movie : moviesWithSameProducer) {
            movie.getStaff().put(producer, Collections.singleton(Role.PRODUCER));
            getDao().create(movie);
        }

        getDao().create(generateEntity());

        List<Movie> moviesFromDb = ((MovieDao) getDao()).findByProducer(producer.getName());

        assertNotNull(moviesFromDb);
        assertEquals(3, moviesFromDb.size());

        for (Movie movie : moviesWithSameProducer) {
            assertTrue(moviesFromDb.contains(movie));
        }
    }

    @Test
    public void testFindByCastMember() {
        List<Movie> moviesWithSameCastMember = Arrays.asList(
                generateEntity()
                , generateEntity()
                , generateEntity()
        );

        Person castMember = generatePerson();

        for (Movie movie : moviesWithSameCastMember) {
            movie.getStaff().put(castMember, Collections.singleton(Role.CAST));
            getDao().create(movie);
        }

        getDao().create(generateEntity());

        List<Movie> moviesFromDb = ((MovieDao) getDao()).findByCastMember(castMember.getName());

        assertNotNull(moviesFromDb);
        assertEquals(3, moviesFromDb.size());

        for (Movie movie : moviesWithSameCastMember) {
            assertTrue(moviesFromDb.contains(movie));
        }
    }

    @Override
    protected Movie generateEntity() {
        Movie movie = new Movie();

        movie.setTitle(UUID.randomUUID().toString());
        movie.setRating(MpaaRating.PG);
        movie.setReleaseYear(LocalDate.of(1988, Month.JULY, 25));

        Map<Person, Set<Role>> staff = new HashMap<>();
        staff.put(generatePerson(), Collections.singleton(Role.DIRECTOR));
        staff.put(generatePerson(), Collections.singleton(Role.PRODUCER));
        staff.put(generatePerson(), Collections.singleton(Role.CAST));
        staff.put(generatePerson(), Collections.singleton(Role.CAST));
        staff.put(generatePerson(), Collections.singleton(Role.CAST));
        movie.setStaff(staff);

        return movie;
    }

    private Person generatePerson() {
        Person person = new Person();

        person.setName(UUID.randomUUID().toString());

        return person;
    }

    @Override
    protected void updateEntity(Movie entity) {
        entity.setTitle(UUID.randomUUID().toString());
        entity.setReleaseYear(LocalDate.of(2016, Month.JUNE, 13));
    }
}
