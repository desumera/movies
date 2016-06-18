package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by david on 6/11/16.
 */
@Data
public class BaseEntity {

    @JsonIgnore
    private UUID uuid;

    @JsonProperty
    private LocalDate createDate;

    @JsonProperty
    private LocalDate updateDate;

    @JsonProperty
    private Long etag;

    @JsonProperty
    private Uri uri;
}
