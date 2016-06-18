package com.j0llysnowman.movies.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by david on 6/17/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Reservation extends BaseEntity<Reservation> implements Comparable<Reservation> {

    private LocalDate reservationDate;

    //    private UriParts<ParkingSpot> parkingSpotUri;

    private UriParts<Person> squatterUri;

    @Override
    public UriParts<Reservation> getUriParts() {
        return new UriParts<>(this);
    }

    @Override
    public int compareTo(Reservation o) {
        return reservationDate.compareTo(o.getReservationDate());
    }
}
