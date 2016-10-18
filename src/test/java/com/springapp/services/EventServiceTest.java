package com.springapp.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EventServiceTest {

    private EventService eventService;

    @Before
    public void init() {
        eventService = new EventService();
    }

    @Test
    public void getEvent() throws Exception {
        Object event = eventService.getEventFromJsonFile(1);
        assertNotNull(event);
        assertTrue(event.toString().startsWith("{"));
        //TODO check / validate json
    }

}