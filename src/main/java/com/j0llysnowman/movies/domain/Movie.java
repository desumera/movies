package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

/**
 * Created by david on 6/11/16.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity {

    @JsonProperty
    private String title;

    @JsonProperty
    private LocalDate releaseYear;

    @JsonProperty
    private Map<Person, Set<Role>> staff;

    @JsonProperty
    private MpaaRating rating;
}
