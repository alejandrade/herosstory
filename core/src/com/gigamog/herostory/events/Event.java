package com.gigamog.herostory.events;

import com.gigamog.herostory.enums.Months;
import com.gigamog.herostory.enums.Weathers;

public class Event {

    private String name;
    private Months month;
    private int dayOfMonth;
    private Weathers weather;

    private Event nextEvent;

    public Event(String name, Months month, int day, Event next, StoryNode startNode) {
        this.name = name;
        this.month = month;
        this.dayOfMonth = day;
        this.nextEvent = next;

        StringBuilder sb = new StringBuilder();
        sb.append("\n" + startNode.getCharacter().getName() + " (" + startNode.getEmotion().name() + ")");
        sb.append("\n" + startNode.getMessage());
        System.out.println(sb.toString());
    }

}
