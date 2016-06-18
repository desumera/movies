package com.j0llysnowman.movies.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Created by david on 6/17/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Reservation extends BaseEntity implements Comparable<Reservation> {

    private LocalDate reservationDate;

    private Uri<ParkingSpot> parkingSpotUri;

    private Uri<Person> squatterUri;

    @Override
    public int compareTo(Reservation o) {
        return reservationDate.compareTo(o.getReservationDate());
    }
}
