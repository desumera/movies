package com.j0llysnowman.movies.resource;

import com.codahale.metrics.annotation.Timed;
import com.j0llysnowman.movies.crud.PersonCrud;
import com.j0llysnowman.movies.domain.Person;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by david on 6/14/16.
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonCrud personDao;

    public PersonResource(PersonCrud personDao) {
        this.personDao = personDao;
    }

    @GET
    @Timed
    public Person getSamplePerson() {
        Person person = new Person();

        person.setName("Peter Jackson");
        person.setUuid(UUID.randomUUID());

        return person;
    }

    @POST
    @Timed
    @Path("person")
    public Person createPerson(Person person) {
        return personDao.create(person);
    }
}
