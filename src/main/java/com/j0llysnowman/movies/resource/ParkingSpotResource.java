package com.j0llysnowman.movies.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.j0llysnowman.movies.crud.ParkingSpotCrud;
import com.j0llysnowman.movies.dao.ParkingSpotDao;
import com.j0llysnowman.movies.domain.Calendar;
import com.j0llysnowman.movies.domain.ParkingSpot;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dsumera on 6/18/16.
 */
@Path("/parkingSpots")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParkingSpotResource implements ParkingSpotCrud
    {

    private static final Logger log = LoggerFactory.getLogger(ParkingSpotResource.class);

    private final ParkingSpotDao parkingSpotDao;

    public ParkingSpotResource(ParkingSpotDao parkingSpotDao) {
        this.parkingSpotDao = parkingSpotDao;
    }

    @GET
    @Timed
    @Path("sample")
    public ParkingSpot getSample() {
        log.info("GETting sample ParkingSpot");

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
        calendar.setUuid(UUID.randomUUID());
        calendar.setReservations(Arrays.asList(
            reservation1
            , reservation2
        ));
        calendar.setEtag(5L);
        calendar.setCreateDate(LocalDate.now().minusYears(5));
        calendar.setUpdateDate(LocalDate.now().minusMonths(1));

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setOwnerUri(new UriParts<>(Person.class, UUID.randomUUID()));
        parkingSpot.setUuid(UUID.randomUUID());
        parkingSpot.setLocation("HQ-1");
        parkingSpot.setEtag(3L);
        parkingSpot.setCalendar(calendar);
        parkingSpot.setCreateDate(LocalDate.now().minusYears(5));
        parkingSpot.setUpdateDate(LocalDate.now().minusYears(2));

        return parkingSpot;
    }

    @POST
    @Timed
    @Override
    public ParkingSpot create(ParkingSpot entity) {
        return parkingSpotDao.create(entity);
    }

    @GET
    @Timed
    @Path("{uuid}")
    @Override
    public ParkingSpot get(
        @PathParam("uuid")
        UUID entityUuid
    )
    {
        return parkingSpotDao.get(entityUuid);
    }

    @PUT
    @Timed
    @Override
    public ParkingSpot update(ParkingSpot entity) {
        return parkingSpotDao.update(entity);
    }

    @DELETE
    @Timed
    @Path("{uuid}")
    @Override
    public ParkingSpot delete(
        @PathParam("uuid")
        UUID entityUuid)
    {
        return null;
    }

    @GET
    @Timed
    @Override
    public List<ParkingSpot> getAll() {
        return null;
    }
    }
