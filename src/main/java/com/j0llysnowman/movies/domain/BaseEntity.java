package com.j0llysnowman.movies.domain;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by david on 6/11/16.
 */
@Data
public abstract class BaseEntity<Entity extends BaseEntity> {

    @JsonIgnore
    private UUID uuid;

    @JsonProperty
    private LocalDate createDate;

    @JsonProperty
    private LocalDate updateDate;

    @JsonProperty
    private Long etag;

    @JsonGetter
    public abstract UriParts<Entity> getUriParts();
}
