package com.springapp.model;

import java.util.*;

/**
 * Created by mk on 2016-12-27.
 */
public class TrainingEvent {

    private int id;
    private String name;
    private String date;
    private String time;
    private String imageUrl;

    private EventLocation location;

    private List<EventSessions> sessions;

    public TrainingEvent() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public EventLocation getLocation() {
        return location;
    }

    public void setLocation(EventLocation location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EventSessions> getSessions() {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        return sessions;
    }

    public void setSessions(List<EventSessions> sessions) {
        this.sessions = sessions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
