package com.springapp.mvc;

import com.springapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventDataController {

	@Autowired
	EventService eventService;

	@ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data/event/{idx}")
    public Object readEventData(@PathVariable Integer idx) {
		return eventService.getEventFromJsonFile(idx);
	}

	@ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data/event")
    public Object readAllEventData() {
		return eventService.getAllEventsFromJsonFileStorage();
	}


	/**
	 * diff to class example
	 * @param eventInJson
	 * @return
	 */
	@ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/data/event/create")
    public Object saveEventData(String eventInJson) {
		return eventService.saveNewEventFromJsonFile(eventInJson);
	}


}