package com.j0llysnowman.movies.facade;

import com.j0llysnowman.movies.crud.MovieCrud;
import com.j0llysnowman.movies.dao.MovieDao;
import com.j0llysnowman.movies.dao.PersonDao;
import com.j0llysnowman.movies.domain.Movie;
import com.j0llysnowman.movies.domain.Person;

import java.util.List;
import java.util.UUID;

/**
 * Created by david on 6/12/16.
 */
public class MovieFacade implements MovieCrud {

    private final MovieDao movieDao;

    private final PersonDao personDao;

    public MovieFacade(MovieDao movieDao, PersonDao personDao) {
        this.movieDao = movieDao;
        this.personDao = personDao;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieDao.findByTitle(title);
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return movieDao.findByDirector(director);
    }

    @Override
    public List<Movie> findByProducer(String producer) {
        return movieDao.findByProducer(producer);
    }

    @Override
    public List<Movie> findByCastMember(String castMember) {
        return movieDao.findByCastMember(castMember);
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
        entity.getStaff().keySet()
                .stream()
                .filter(staffMember -> staffMember.getUri().getUuid() == null)
                .forEach(staffMember -> {
                    Person existing = personDao.findByName(staffMember.getName());

                    if (existing == null) {
                        personDao.create(staffMember);
                    } else {
                        staffMember.setUri(existing.getUri());
                    }
                });
    }
}
