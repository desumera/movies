package com.j0llysnowman.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Created by david on 6/11/16.
 */
@Data
public class BaseEntity {

    @JsonProperty
    private UUID uuid;
}
