package com.j0llysnowman.movies.domain;

import java.util.UUID;

import com.j0llysnowman.movies.domain.enums.EntityCollection;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by david on 6/17/16.
 */
@Getter
@Setter
public class UriParts<Entity extends BaseEntity> {

    private String uri;

    private UUID uuid;

    private EntityCollection entityCollection;

    public UriParts(Entity entity) {
        this(entity.getClass(), entity.getUuid());
    }

    public UriParts(Class clazz, UUID uuid) {
        this.uuid = uuid;
        this.entityCollection = EntityCollection.getByClazz(clazz);
        uri = "/" + entityCollection.getPath() + "/" + uuid;
    }
}
