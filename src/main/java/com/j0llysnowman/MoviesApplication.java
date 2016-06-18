package com.j0llysnowman;

import com.j0llysnowman.movies.dao.MemoryMovieDao;
import com.j0llysnowman.movies.dao.MemoryPersonDao;
import com.j0llysnowman.movies.dao.MovieDao;
import com.j0llysnowman.movies.dao.PersonDao;
import com.j0llysnowman.movies.facade.MovieFacade;
import com.j0llysnowman.movies.resource.MovieResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by david on 6/12/16.
 */
public class MoviesApplication extends Application<MoviesConfiguration> {

    public static void main(String[] args) throws Exception {
        new MoviesApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MoviesConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(MoviesConfiguration configuration, Environment environment) {
        final MovieDao movieDao = new MemoryMovieDao();
        final PersonDao personDao = new MemoryPersonDao();
        final MovieFacade movieFacade = new MovieFacade(movieDao, personDao);
        final MovieResource resource = new MovieResource(configuration.getDefaultMovieTitle(), movieFacade);

        environment.jersey().register(resource);
    }
}
