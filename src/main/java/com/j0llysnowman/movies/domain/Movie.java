package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j0llysnowman.movies.domain.enums.MpaaRating;
import com.j0llysnowman.movies.domain.enums.Role;
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

    @JsonProperty(required = true)
    private String title;

    @JsonProperty(required = true)
    private LocalDate releaseYear;

    @JsonProperty(required = true)
    private Map<Person, Set<Role>> staff;

    @JsonProperty(required = true)
    private MpaaRating rating;
}
