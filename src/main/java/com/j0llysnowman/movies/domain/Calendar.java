package com.j0llysnowman.movies.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by dsumera on 6/18/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Calendar extends BaseEntity<Calendar> {

    @JsonProperty
    private List<Reservation> reservations;

    @Override
    public UriParts<Calendar> getUriParts() {
        return new UriParts<>(this);
    }
}
