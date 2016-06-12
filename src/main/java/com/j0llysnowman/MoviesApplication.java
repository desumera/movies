package com.j0llysnowman;

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
        final MovieResource resource = new MovieResource(configuration.getDefaultMovieTitle());

        environment.jersey().register(resource);
    }
}
