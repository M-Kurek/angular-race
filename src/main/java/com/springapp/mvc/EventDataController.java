package com.springapp.mvc;

import com.springapp.model.TrainingEvent;
import com.springapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventDataController {

	@Autowired
	EventService eventService;

    @RequestMapping(method = RequestMethod.GET, value = "/data/event/{idx}")
    public Object readEventData(@PathVariable Integer idx) {
		return eventService.getEventFromJsonFile(idx);
	}

    @RequestMapping(method = RequestMethod.GET, value = "/data/event")
    public List<TrainingEvent> readAllEventData() {
		return eventService.getAllEvents();
	}


	/**
	 * Accept data to save.
	 * @param eventToSave
	 * @return
	 */
    @RequestMapping(method = RequestMethod.POST, value = "/data/event/create")
    public Object saveEventData(@RequestBody TrainingEvent eventToSave) {
		return eventService.saveNewEvent(eventToSave);
	}


}