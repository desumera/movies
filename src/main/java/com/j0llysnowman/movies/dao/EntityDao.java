package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.BaseEntity;

import java.util.List;
import java.util.UUID;

/**
 * Created by david on 6/11/16.
 */
public interface EntityDao<Entity extends BaseEntity> {

    Entity create(Entity entity);

    Entity get(UUID entityUuid);

    Entity update(Entity entity);

    Entity delete(UUID entityUuid);

    List<Entity> getAll();
}
