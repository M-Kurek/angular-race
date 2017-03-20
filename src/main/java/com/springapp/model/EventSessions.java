package com.springapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mk on 2017-03-20.
 */
public class EventSessions {

    private long id;
    private int duration;
    private String name;
    private String creator;
    private String creatorName;
    private String level;
    private String track;
    private int upVoteCount;

    @JsonProperty(value = "abstract")
    private String abstractTxt;

    public EventSessions() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public String getAbstractTxt() {
        return abstractTxt;
    }

    public void setAbstractTxt(String abstractTxt) {
        this.abstractTxt = abstractTxt;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
