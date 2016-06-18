package com.j0llysnowman.movies.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.enums.MpaaRating;
import com.j0llysnowman.movies.domain.enums.Role;

/**
 * Created by david on 6/11/16.
 */
public abstract class MovieDaoTest extends BaseEntityDaoTest<Movie> {

    @Override
    protected Movie generateEntity() {
        Movie movie = new Movie();

        movie.setTitle(UUID.randomUUID().toString());
        movie.setRating(MpaaRating.PG);
        movie.setReleaseYear(LocalDate.of(1988, Month.JULY, 25));

        Map<UUID, Set<Role>> staff = new HashMap<>();
        staff.put(generatePerson().getUuid(), Collections.singleton(Role.DIRECTOR));
        staff.put(generatePerson().getUuid(), Collections.singleton(Role.PRODUCER));
        staff.put(generatePerson().getUuid(), Collections.singleton(Role.CAST));
        staff.put(generatePerson().getUuid(), Collections.singleton(Role.CAST));
        staff.put(generatePerson().getUuid(), Collections.singleton(Role.CAST));
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
