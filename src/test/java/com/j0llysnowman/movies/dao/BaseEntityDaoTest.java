package com.j0llysnowman.movies.dao;

import com.j0llysnowman.movies.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by david on 6/11/16.
 */
@Setter
@Getter
public abstract class BaseEntityDaoTest<Entity extends BaseEntity> {

    private EntityDao<Entity> dao;

    @Test
    public void testCrud() {
        Entity entity = generateEntity();

        assertNull(entity.getUuid());
        Entity inserted = dao.create(entity);
        assertNotNull(entity.getUuid());
        assertNotNull(inserted);

        updateEntity(inserted);
        Entity updated = dao.update(inserted);
        assertEquals(inserted, updated);

        Entity deleted = dao.delete(updated.getUuid());
        assertEquals(updated, deleted);

        Entity notFound = dao.get(deleted.getUuid());
        assertNull(notFound);
    }

    protected abstract Entity generateEntity();

    protected abstract void updateEntity(Entity entity);

}