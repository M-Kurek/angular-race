package com.springapp.services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import static com.springapp.services.EventService.THE_PATH;
import static org.junit.Assert.*;


public class EventServiceTest {

    private EventService eventService;

    @Before
    public void init() {
        eventService = new EventService();
    }

    @Test
    public void countWritten() throws Exception {
        assertEquals(2, eventService.getNextId(ResourceUtils.getFile("classpath:" + THE_PATH)));
    }
    @Test
    public void getEvent() throws Exception {
        Object event = eventService.getEventFromJsonFile(1);
        assertNotNull(event);
        assertTrue(event.toString().startsWith("{"));
        //TODO check / validate json
    }

}