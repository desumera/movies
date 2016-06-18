package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by david on 6/17/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ParkingSpot extends BaseEntity<ParkingSpot> {

    @JsonProperty
    private Calendar calendar;

    @JsonProperty
    private String location;

    @JsonProperty
    private UriParts<Person> ownerUri;

    @Override
    public UriParts<ParkingSpot> getUriParts() {
        return new UriParts<>(this);
    }
}
