package com.gigamog.herostory.events;

public class StoryNodeChoice {
    String name;
    StoryNode node;

    public StoryNodeChoice(String name, StoryNode node) {
        this.name = name;
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoryNode getNode() {
        return node;
    }

    public void setNode(StoryNode node) {
        this.node = node;
    }
}
