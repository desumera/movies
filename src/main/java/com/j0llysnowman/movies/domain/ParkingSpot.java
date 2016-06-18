package com.j0llysnowman.movies.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by david on 6/17/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ParkingSpot extends BaseEntity {

//    private List<Reservation> calendar;

    private String location;

    private Uri<Person> owner;
}
