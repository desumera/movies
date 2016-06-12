package com.j0llysnowman.movies.dao;

import org.junit.After;
import org.junit.Before;

/**
 * Created by david on 6/11/16.
 */
public class MemoryPersonDaoTest extends PersonDaoTest {

    private MemoryPersonDao memoryPersonDao;

    @Before
    public void setup() {
        memoryPersonDao = new MemoryPersonDao();
        setDao(memoryPersonDao);
    }

    @After
    public void tearDown() {
        memoryPersonDao = null;
    }
}
