package com.j0llysnowman.movies.dao;

import java.time.LocalDate;
import java.util.UUID;

import com.j0llysnowman.movies.domain.ParkingSpot;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by david on 6/17/16.
 */
public abstract class ReservationDaoTest extends BaseEntityDaoTest<Reservation> {

    @Override
    protected Reservation generateEntity() {
        Reservation reservation = new Reservation();

        reservation.setReservationDate(LocalDate.now());
        reservation.setSquatterUri(new UriParts<>(generatePerson()));

        return reservation;
    }

    protected ParkingSpot generateParkingSpot() {
        ParkingSpot parkingSpot = new ParkingSpot();

        parkingSpot.setLocation("HQ105");
        parkingSpot.setOwnerUri(new UriParts<>(generatePerson()));

        return parkingSpot;
    }

    protected Person generatePerson() {
        Person person = new Person();
        UUID uuid = UUID.randomUUID();

        person.setName(uuid.toString());
        person.setUuid(uuid);

        return person;
    }

    @Override
    protected void updateEntity(Reservation entity) {
        entity.setReservationDate(entity.getReservationDate().plusDays(5));
    }
}
