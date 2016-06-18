package com.j0llysnowman.movies.resource;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Sets;
import com.j0llysnowman.movies.crud.MovieCrud;
import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.enums.MpaaRating;
import com.j0llysnowman.movies.domain.enums.Role;
import com.j0llysnowman.movies.facade.MovieFacade;

/**
 * Created by david on 6/11/16.
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource implements MovieCrud {

    private final String defaultMovieTitle;

    private final MovieFacade movieFacade;

    public MovieResource(String defaultMovieTitle, MovieFacade movieFacade) {
        this.defaultMovieTitle = defaultMovieTitle;
        this.movieFacade = movieFacade;
    }

    @GET
    @Path("sample")
    @Timed
    public Movie getSampleMovie(
        @QueryParam("title")
        String title) {
        Movie movie = new Movie();

        movie.setTitle(Optional.ofNullable(title).orElse(defaultMovieTitle));
        movie.setReleaseYear(LocalDate.of(2000, Month.JANUARY, 1));
        movie.setRating(MpaaRating.PG);
        movie.setUuid(UUID.randomUUID());
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

        Map<UUID, Set<Role>> staff = new HashMap<>();
        staff.put(UUID.randomUUID(), Collections.singleton(Role.DIRECTOR));
        staff.put(UUID.randomUUID(), Collections.singleton(Role.PRODUCER));
        staff.put(UUID.randomUUID(), Sets.newHashSet(Role.PRODUCER, Role.CAST));
        movie.setStaff(staff);

        return movie;
    }

    @POST
    @Timed
    public Movie create(Movie movie) {
        return movieFacade.create(movie);
    }

    @GET
    @Timed
    @Path("{movieUuid}")
    public Movie get(
        @PathParam("movieUuid")
        UUID movieUuid) {
        return movieFacade.get(movieUuid);
    }

    @PUT
    @Timed
    public Movie update(Movie movie) {
        return movieFacade.update(movie);
    }

    @DELETE
    @Timed
    @Path("{movieUuid}")
    public Movie delete(
        @PathParam("movieUuid")
        UUID movieUuid) {
        return movieFacade.delete(movieUuid);
    }

    @GET
    @Timed
    @Override
    public List<Movie> getAll() {
        return movieFacade.getAll();
    }
}
