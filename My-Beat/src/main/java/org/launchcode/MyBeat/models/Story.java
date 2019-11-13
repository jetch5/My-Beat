package org.launchcode.MyBeat.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Story {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Must describe your story!")
    private String description;

    private int storyId;
    private static int nextId = 1;

    public Story(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Story() {
        storyId = nextId;
        nextId++;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
