package com.j0llysnowman.movies.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Sets;
import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Uri;
import com.j0llysnowman.movies.domain.enums.MpaaRating;
import com.j0llysnowman.movies.domain.enums.Role;
import com.j0llysnowman.movies.facade.MovieFacade;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

    private final String defaultMovieTitle;

    private final MovieFacade movieFacade;

    public MovieResource(String defaultMovieTitle, MovieFacade movieFacade) {
        this.defaultMovieTitle = defaultMovieTitle;
        this.movieFacade = movieFacade;
    }

    @GET
    @Timed
    public Movie getSampleMovie(@QueryParam("title") String title) {
        Movie movie = new Movie();

        movie.setTitle(Optional.ofNullable(title).orElse(defaultMovieTitle));
        movie.setReleaseYear(LocalDate.of(2000, Month.JANUARY, 1));
        movie.setRating(MpaaRating.PG);
        movie.setUuid(UUID.randomUUID());
        movie.setUri(new Uri<>(movie));
        movie.setEtag(1L);
        movie.setCreateDate(LocalDate.now());
        movie.setUpdateDate(LocalDate.now());

        Person director = new Person();
        director.setName("JJ Abrams");
        director.setUuid(UUID.randomUUID());
        director.setCreateDate(LocalDate.now());
        director.setUpdateDate(LocalDate.now());

        Person producer = new Person();
        producer.setName("Ridley Scott");
        producer.setUuid(UUID.randomUUID());
        producer.setCreateDate(LocalDate.now());
        producer.setUpdateDate(LocalDate.now());

        Person star = new Person();
        star.setName("Michael Jordan");
        star.setUuid(UUID.randomUUID());
        star.setCreateDate(LocalDate.now());
        star.setUpdateDate(LocalDate.now());

        Map<Person, Set<Role>> staff = new HashMap<>();
        staff.put(director, Collections.singleton(Role.DIRECTOR));
        staff.put(producer, Collections.singleton(Role.PRODUCER));
        staff.put(star, Sets.newHashSet(Role.PRODUCER, Role.CAST));
        movie.setStaff(staff);

        return movie;
    }

    @POST
    @Timed
    @Path("movie")
    public Movie createMovie(Movie movie) {
        return movieFacade.create(movie);
    }

    @GET
    @Timed
    @Path("movie/{movieUuid}")
    public Movie getMovie(@PathParam("movieUuid") UUID movieUuid) {
        return movieFacade.get(movieUuid);
    }

    @PUT
    @Timed
    @Path("movie")
    public Movie updateMovie(Movie movie) {
        return movieFacade.update(movie);
    }

    @DELETE
    @Timed
    @Path("movie/{movieUuid}")
    public Movie deleteMovie(@PathParam("movieUuid") UUID movieUuid) {
        return movieFacade.delete(movieUuid);
    }
}
