package com.j0llysnowman.movies.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.j0llysnowman.movies.crud.CalendarCrud;
import com.j0llysnowman.movies.dao.CalendarDao;
import com.j0llysnowman.movies.domain.Calendar;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by dsumera on 6/18/16.
 */
@Path("/calendars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalendarResource implements CalendarCrud {

    private final CalendarDao calendarDao;

    public CalendarResource(CalendarDao calendarDao) {
        this.calendarDao = calendarDao;
    }

    @GET
    @Timed
    @Path("sample")
    public Calendar getSample() {
        Reservation reservation1 = new Reservation();
        reservation1.setReservationDate(LocalDate.now().plusMonths(1));
        reservation1.setSquatterUri(new UriParts<>(Person.class, UUID.randomUUID()));
        reservation1.setEtag(1L);
        reservation1.setUuid(UUID.randomUUID());
        reservation1.setCreateDate(LocalDate.now().minusMonths(1));
        reservation1.setUpdateDate(LocalDate.now().minusMonths(1));

        Reservation reservation2 = new Reservation();
        reservation2.setReservationDate(LocalDate.now().plusMonths(2));
        reservation2.setSquatterUri(new UriParts<>(Person.class, UUID.randomUUID()));
        reservation2.setEtag(2L);
        reservation2.setUuid(UUID.randomUUID());
        reservation2.setCreateDate(LocalDate.now().minusMonths(1));
        reservation2.setUpdateDate(LocalDate.now().minusMonths(1));

        Calendar calendar = new Calendar();
        calendar.setEtag(1L);
        calendar.setUuid(UUID.randomUUID());
        calendar.setCreateDate(LocalDate.now().minusYears(1));
        calendar.setUpdateDate(LocalDate.now().minusDays(1));
        calendar.setReservations(Arrays.asList(
            reservation1
            , reservation2
        ));

        return calendar;
    }

    @Override
    public Calendar create(Calendar entity) {
        return null;
    }

    @Override
    public Calendar get(UUID entityUuid) {
        return null;
    }

    @Override
    public Calendar update(Calendar entity) {
        return null;
    }

    @Override
    public Calendar delete(UUID entityUuid) {
        return null;
    }

    @Override
    public List<Calendar> getAll() {
        return null;
    }
}
