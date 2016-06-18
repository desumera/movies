package com.j0llysnowman.movies.facade;

import java.util.List;
import java.util.UUID;

import com.j0llysnowman.movies.crud.MovieCrud;
import com.j0llysnowman.movies.dao.MovieDao;
import com.j0llysnowman.movies.domain.Movie;

/**
 * Created by david on 6/12/16.
 */
public class MovieFacade implements MovieCrud {

    private final MovieDao movieDao;

    public MovieFacade(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie create(Movie entity) {
        makeSureStaffExists(entity);
        return movieDao.create(entity);
    }

    @Override
    public Movie get(UUID entityUuid) {
        return movieDao.get(entityUuid);
    }

    @Override
    public Movie update(Movie entity) {
        makeSureStaffExists(entity);
        return movieDao.update(entity);
    }

    @Override
    public Movie delete(UUID entityUuid) {
        return movieDao.delete(entityUuid);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    private void makeSureStaffExists(Movie entity) {
        //        entity.getStaff().keySet()
        //                .stream()
        //                .filter(staffMember -> staffMember == null)
        //                .forEach(staffMember -> {
        //                    Person existing = personDao.get(staffMember);
        //
        //                    if (existing == null) {
        //                        personDao.create(staffMember);
        //                    } else {
        //                        staffMember.setUriParts(existing.getUriParts());
        //                    }
        //                });
    }
}
