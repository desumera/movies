package com.j0llysnowman.movies.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Sets;
import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.MpaaRating;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Role;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by david on 6/11/16.
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    private final String defaultMovieTitle;

    public MovieResource(String defaultMovieTitle) {
        this.defaultMovieTitle = defaultMovieTitle;
    }

    @GET
    @Timed
    public Movie getSampleMovie(@QueryParam("title") Optional<String> title) {
        Movie movie = new Movie();

        movie.setTitle(title.orElse(defaultMovieTitle));
        movie.setReleaseYear(LocalDate.of(2000, Month.JANUARY, 1));
        movie.setRating(MpaaRating.PG);
        movie.setUuid(UUID.randomUUID());

        Person director = new Person();
        director.setName("JJ Abrams");
        director.setUuid(UUID.randomUUID());

        Person producer = new Person();
        producer.setName("Ridley Scott");
        producer.setUuid(UUID.randomUUID());

        Person star = new Person();
        star.setName("Michael Jordan");
        star.setUuid(UUID.randomUUID());

        Map<Person, Set<Role>> staff = new HashMap<>();
        staff.put(director, Collections.singleton(Role.DIRECTOR));
        staff.put(producer, Collections.singleton(Role.PRODUCER));
        staff.put(star, Sets.newHashSet(Role.PRODUCER, Role.CAST));
        movie.setStaff(staff);

        return movie;
    }
}
