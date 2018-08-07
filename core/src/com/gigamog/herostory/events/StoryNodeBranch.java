package com.gigamog.herostory.events;

public class StoryNodeBranch {
    private StoryNodeChoice[] choices;

    public StoryNodeBranch(StoryNodeChoice ... choices) {
        this.choices = choices;
    }
}
