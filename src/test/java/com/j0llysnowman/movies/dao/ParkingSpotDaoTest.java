package com.j0llysnowman.movies.dao;

import java.util.UUID;

import com.j0llysnowman.movies.domain.ParkingSpot;
import com.j0llysnowman.movies.domain.Person;
import com.j0llysnowman.movies.domain.UriParts;

/**
 * Created by dsumera on 6/18/16.
 */
public abstract class ParkingSpotDaoTest extends BaseEntityDaoTest<ParkingSpot> {

    @Override
    protected ParkingSpot generateEntity() {
        ParkingSpot parkingSpot = new ParkingSpot();

        parkingSpot.setLocation(UUID.randomUUID().toString());
        parkingSpot.setOwnerUri(new UriParts<>(Person.class, UUID.randomUUID()));

        return parkingSpot;
    }

    @Override
    protected void updateEntity(ParkingSpot entity) {
        entity.setLocation(UUID.randomUUID().toString());
        entity.setOwnerUri(new UriParts<>(Person.class, UUID.randomUUID()));
    }
}
