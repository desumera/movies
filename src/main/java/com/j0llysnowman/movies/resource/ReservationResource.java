package com.j0llysnowman.movies.resource;

import java.time.LocalDate;
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
import com.j0llysnowman.movies.crud.ReservationCrud;
import com.j0llysnowman.movies.dao.ReservationDao;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by dsumera on 6/17/16.
 */
@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationResource implements ReservationCrud {

    private final ReservationDao reservationDao;

    public ReservationResource(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @GET
    @Timed
    @Path("sample")
    public Reservation getSample() {
        Reservation reservation = new Reservation();
        reservation.setUuid(UUID.randomUUID());
        reservation.setReservationDate(LocalDate.now());
        reservation.setSquatterUri(new UriParts<>(Person.class, UUID.randomUUID()));
        reservation.setEtag(3L);
        reservation.setCreateDate(LocalDate.now().minusDays(10));
        reservation.setUpdateDate(LocalDate.now().minusDays(14));

        return reservation;
    }

    @POST
    @Timed
    @Override
    public Reservation create(Reservation entity) {
        return reservationDao.create(entity);
    }

    @GET
    @Timed
    @Path(value = "{uuid}")
    @Override
    public Reservation get(
        @PathParam("uuid")
        UUID entityUuid) {
        return reservationDao.get(entityUuid);
    }

    @PUT
    @Timed
    @Override
    public Reservation update(Reservation entity) {
        return reservationDao.update(entity);
    }

    @DELETE
    @Timed
    @Path(value = "{uuid}")
    @Override
    public Reservation delete(
        @PathParam("uuid")
        UUID entityUuid) {
        return null;
    }

    @GET
    @Timed
    @Override
    public List<Reservation> getAll() {
        return null;
    }
}
