package com.j0llysnowman.movies.dao;

import com.google.common.base.Preconditions;
import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.enums.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by david on 6/11/16.
 */
public class MemoryMovieDao extends MemoryEntityDao<Movie> implements MovieDao {

    @Override
    public List<Movie> findByTitle(String title) {
        Preconditions.checkNotNull(title);

        List<Movie> movies = getAll();
        movies.removeIf(movie -> !title.equals(movie.getTitle()));

        return movies;
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return findByRole(director, Role.DIRECTOR);
    }

    @Override
    public List<Movie> findByProducer(String producer) {
        return findByRole(producer, Role.PRODUCER);
    }

    @Override
    public List<Movie> findByCastMember(String castMember) {
        return findByRole(castMember, Role.CAST);
    }

    private List<Movie> findByRole(String name, Role role) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(role);

        List<Movie> movies = getAll();
        movies.removeIf(movie -> {
            for (Person person : movie.getStaff().keySet()) {
                Set<Role> roles = movie.getStaff().get(person);

                if (name.equals(person.getName()) && roles.contains(role)) {
                    return false;
                }
            }

            return true;
        });

        return movies;
    }
}
