package com.j0llysnowman.movies.dao;

import com.google.common.base.Preconditions;
import com.j0llysnowman.movies.domain.BaseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by david on 6/11/16.
 */
public class MemoryEntityDao<Entity extends BaseEntity> implements EntityDao<Entity> {

    private Map<UUID, Entity> database;

    public MemoryEntityDao() {
        database = new HashMap<>();
    }

    @Override
    public Entity create(Entity entity) {
        Preconditions.checkArgument(entity.getUuid() == null);

        UUID newUuid = UUID.randomUUID();
        entity.setUuid(newUuid);
        database.put(newUuid, entity);
        return database.get(newUuid);
    }

    @Override
    public Entity get(UUID entityUuid) {
        Preconditions.checkNotNull(entityUuid);

        return database.get(entityUuid);
    }

    @Override
    public Entity update(Entity entity) {
        Preconditions.checkNotNull(entity.getUuid());

        database.put(entity.getUuid(), entity);
        return database.get(entity.getUuid());
    }

    @Override
    public Entity delete(UUID entityUuid) {
        Preconditions.checkNotNull(entityUuid);

        return database.remove(entityUuid);
    }

    @Override
    public List<Entity> getAll() {
        return new ArrayList<>(database.values());
    }
}
