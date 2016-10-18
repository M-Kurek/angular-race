package com.springapp.mvc;

import com.springapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class EventDataController {

	@Autowired
	EventService eventService;

	@ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data/event/{idx}")
    public Object readEventData(@PathVariable Integer idx) {
		return eventService.getEventFromJsonFile(idx);
	}

	@ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/data/event/{idx}")
    public Object saveEventData(@PathVariable Integer idx, String eventInJson) {
		return eventService.saveEventFromJsonFile(idx, eventInJson);
	}

	@ResponseBody
	@RequestMapping("/data/events")
    public String eventData() {
		return "some events";
	}

}