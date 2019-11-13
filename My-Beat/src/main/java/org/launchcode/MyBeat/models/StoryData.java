package org.launchcode.MyBeat.models;

import java.util.ArrayList;

public class StoryData {

    static ArrayList<Story> stories = new ArrayList<>();

    //getAll
    public static ArrayList<Story> getAll() {
        return stories;
    }

    //add
    public static void add(Story newStory) {
        stories.add(newStory);
    }

    //remove

    public static void remove(int id) {
        Story storyToRemove = getById(id);
        stories.remove(storyToRemove);

    }

    //getById
    public static Story getById(int id) {
        Story theStory = null;
        for (Story candidateStory: stories) {
            if (candidateStory.getStoryId() ==id) {
                theStory = candidateStory;
            }
        }
        return theStory;

    }
}
