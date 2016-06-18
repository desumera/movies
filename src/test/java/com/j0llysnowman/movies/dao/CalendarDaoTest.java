package com.j0llysnowman.movies.dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import com.j0llysnowman.movies.domain.Calendar;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by dsumera on 6/18/16.
 */
public abstract class CalendarDaoTest extends BaseEntityDaoTest<Calendar> {

    @Override
    protected Calendar generateEntity() {
        Calendar calendar = new Calendar();
        calendar.setReservations(Arrays.asList(
            generateReservation()
            , generateReservation()
            , generateReservation()
        ));

        return calendar;
    }

    private Reservation generateReservation() {
        Reservation reservation = new Reservation();
        reservation.setReservationDate(LocalDate.now());
        reservation.setSquatterUri(new UriParts<>(Person.class, UUID.randomUUID()));

        return reservation;

    }

    @Override
    protected void updateEntity(Calendar entity) {

    }
}
