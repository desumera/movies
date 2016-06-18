package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.Movie;

/**
 * Created by david on 6/11/16.
 */
public class MemoryMovieDao extends MemoryEntityDao<Movie> implements MovieDao {

    //    private List<Movie> findByRole(String name, Role role) {
    //        Preconditions.checkNotNull(name);
    //        Preconditions.checkNotNull(role);
    //
    //        List<Movie> movies = getAll();
    //        movies.removeIf(movie -> {
    //            for (UUID personUuid : movie.getStaff().keySet()) {
    //                Person person = personDao.get(personUuid);
    //
    //                if (person == null) {
    //                    throw new NullPointerException("movie " + movie.getUuid() + " has invalid personUuid=" + personUuid + " in staff");
    //                }
    //
    //                Set<Role> roles = movie.getStaff().get(personUuid);
    //
    //                if (name.equals(person.getName()) && roles.contains(role)) {
    //                    return false;
    //                }
    //            }
    //
    //            return true;
    //        });
    //
    //        return movies;
    //    }
}
