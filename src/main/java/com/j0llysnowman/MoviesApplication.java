package com.j0llysnowman;

import com.j0llysnowman.movies.dao.CalendarDao;
import com.j0llysnowman.movies.dao.MemoryCalendarDao;
import com.j0llysnowman.movies.dao.MemoryParkingSpotDao;
import com.j0llysnowman.movies.dao.MemoryPersonDao;
import com.j0llysnowman.movies.dao.MemoryReservationDao;
import com.j0llysnowman.movies.dao.ParkingSpotDao;
import com.j0llysnowman.movies.dao.PersonDao;
import com.j0llysnowman.movies.dao.ReservationDao;
import com.j0llysnowman.movies.resource.CalendarResource;
import com.j0llysnowman.movies.resource.ParkingSpotResource;
import com.j0llysnowman.movies.resource.ReservationResource;

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
        final PersonDao personDao = new MemoryPersonDao();

        final ReservationDao reservationDao = new MemoryReservationDao();
        final ReservationResource reservationResource = new ReservationResource(reservationDao);

        final ParkingSpotDao parkingSpotDao = new MemoryParkingSpotDao();
        final ParkingSpotResource parkingSpotResource = new ParkingSpotResource(parkingSpotDao);

        final CalendarDao calendarDao = new MemoryCalendarDao();
        final CalendarResource calendarResource = new CalendarResource(calendarDao);

        environment.jersey().register(reservationResource);
        environment.jersey().register(parkingSpotResource);
        environment.jersey().register(calendarResource);
    }
}
