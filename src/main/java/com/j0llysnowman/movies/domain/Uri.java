package com.j0llysnowman.movies.domain;

import com.j0llysnowman.movies.domain.enums.EntityCollection;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by david on 6/17/16.
 */
@Getter
public class Uri<Entity extends BaseEntity> {

    private final String uri;

    private final UUID uuid;

    private final EntityCollection entityCollection;

    public Uri(Entity entity) {
        this.uuid = entity.getUuid();
        this.entityCollection = EntityCollection.getByClazz(entity.getClass());
        uri = "/" + entityCollection.getPath() + "/" + uuid;
    }
}
