package com.j0llysnowman.movies.dao;

/**
 * Created by dsumera on 6/18/16.
 */
public class MemoryCalendarDaoTest extends CalendarDaoTest {

    MemoryCalendarDao calendarDao;

    @Override
    public void setup() {
        calendarDao = new MemoryCalendarDao();
        setDao(calendarDao);
    }

    @Override
    public void tearDown() {
        calendarDao = null;
    }
}
