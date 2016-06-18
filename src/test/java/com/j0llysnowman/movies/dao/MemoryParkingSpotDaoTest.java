package com.j0llysnowman.movies.dao;

/**
 * Created by dsumera on 6/18/16.
 */
public class MemoryParkingSpotDaoTest extends ParkingSpotDaoTest {

    MemoryParkingSpotDao parkingSpotDao;

    @Override
    public void setup() {
        parkingSpotDao = new MemoryParkingSpotDao();
        setDao(parkingSpotDao);
    }

    @Override
    public void tearDown() {
        parkingSpotDao = null;
    }
}
