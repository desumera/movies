package com.j0llysnowman.movies.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.j0llysnowman.movies.crud.ParkingSpotCrud;
import com.j0llysnowman.movies.dao.ParkingSpotDao;
import com.j0llysnowman.movies.domain.ParkingSpot;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by dsumera on 6/18/16.
 */
@Path("/parkingSpots")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParkingSpotResource implements ParkingSpotCrud {

    final ParkingSpotDao parkingSpotDao;

    public ParkingSpotResource(ParkingSpotDao parkingSpotDao) {
        this.parkingSpotDao = parkingSpotDao;
    }

    @GET
    @Timed
    @Path("sample")
    public ParkingSpot getSample() {
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

        //        Calendar calendar = new Calendar();
        //        calendar.setUuid(UUID.randomUUID());
        //        calendar.setReservations(Arrays.asList(
        //            reservation1
        //            , reservation2
        //        ));
        //        calendar.setEtag(5L);
        //        calendar.setCreateDate(LocalDate.now().minusYears(5));
        //        calendar.setUpdateDate(LocalDate.now().minusMonths(1));

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setOwnerUri(new UriParts<>(Person.class, UUID.randomUUID()));
        parkingSpot.setUuid(UUID.randomUUID());
        parkingSpot.setLocation("HQ-1");
        parkingSpot.setEtag(3L);
        parkingSpot.setCalendar(null);
        parkingSpot.setCreateDate(LocalDate.now().minusYears(5));
        parkingSpot.setUpdateDate(LocalDate.now().minusYears(2));

        return parkingSpot;
    }

    @Override
    public ParkingSpot create(ParkingSpot entity) {
        return null;
    }

    @Override
    public ParkingSpot get(UUID entityUuid) {
        return null;
    }

    @Override
    public ParkingSpot update(ParkingSpot entity) {
        return null;
    }

    @Override
    public ParkingSpot delete(UUID entityUuid) {
        return null;
    }

    @Override
    public List<ParkingSpot> getAll() {
        return null;
    }
}
