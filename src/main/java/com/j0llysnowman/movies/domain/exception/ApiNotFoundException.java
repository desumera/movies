package com.j0llysnowman.movies.domain.exception;

import javax.ws.rs.core.Response;

import lombok.Getter;

/**
 * Created by dsumera on 6/17/16.
 */
@Getter
public class ApiNotFoundException extends Exception implements ApiException {

    Response.Status status;

    public ApiNotFoundException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }
}
