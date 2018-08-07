package com.gigamog.herostory.events;

import com.gigamog.herostory.enums.Characters;
import com.gigamog.herostory.enums.Emotions;

public class StoryNode {
    private String message;
    private Characters character;
    private Emotions emotion;
    private StoryNodeBranch branch;

    public StoryNode(Characters character, Emotions emotion, String message, StoryNode next) {
        this.character = character;
        this.emotion = emotion;
        this.message = message;
        StoryNodeChoice c = new StoryNodeChoice("Continue", next);
        StoryNodeBranch b = new StoryNodeBranch(c);
        this.branch = b;
    }

    public String getMessage() {
        return message;
    }

    public Characters getCharacter() {
        return character;
    }

    public Emotions getEmotion() {
        return emotion;
    }

    public StoryNodeBranch getBranch() {
        return branch;
    }
}
