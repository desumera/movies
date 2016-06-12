package com.j0llysnowman.movies.dao;

import org.junit.After;
import org.junit.Before;

/**
 * Created by david on 6/11/16.
 */
public class MemoryMovieDaoTest extends MovieDaoTest {

    private MemoryMovieDao memoryMovieDao;

    @Before
    public void setup() {
        memoryMovieDao = new MemoryMovieDao();
        setDao(memoryMovieDao);
    }

    @After
    public void tearDown() {
        memoryMovieDao = null;
    }
}
