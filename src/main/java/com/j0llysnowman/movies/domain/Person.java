package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by david on 6/11/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity<Person> {

    @JsonProperty(required = true)
    private String name;

    @Override
    public UriParts<Person> getUriParts() {
        return new UriParts<>(this);
    }

}
