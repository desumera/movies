package com.j0llysnowman.movies.dao;

/**
 * Created by david on 6/17/16.
 */
public class MemoryReservationDaoTest extends ReservationDaoTest {

    private MemoryReservationDao memoryReservationDao;

    @Override
    public void setup() {
        memoryReservationDao = new MemoryReservationDao();
        setDao(memoryReservationDao);
    }

    @Override
    public void tearDown() {
        memoryReservationDao = null;
    }
}
