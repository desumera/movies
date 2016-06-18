package com.j0llysnowman.movies.domain.enums;

import com.j0llysnowman.movies.domain.BaseEntity;
import com.j0llysnowman.movies.domain.Calendar;
import com.j0llysnowman.movies.domain.ParkingSpot;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.Reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by david on 6/17/16.
 */
@AllArgsConstructor
@Getter
public enum EntityCollection {

    PERSONS(Person.class, "persons"),
    PARKING_SPOTS(ParkingSpot.class, "parkingSpots"),
    RESERVATIONS(Reservation.class, "reservations"),
    CALENDARS(Calendar.class, "calendars");

    private Class entity;

    private String path;

    public static <Entity extends BaseEntity> EntityCollection getByClazz(Class<Entity> clazz) {
        for (EntityCollection entityCollection : values()) {
            if (entityCollection.getEntity().equals(clazz)) {
                return entityCollection;
            }
        }

        throw new IllegalArgumentException(clazz + " does not correspond to an EntityCollection");
    }
}
