package com.j0llysnowman.movies.domain;

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

    private String title;

    private LocalDate releaseYear;

    private Map<Person, Set<Role>> staff;

    private MpaaRating rating;
}
