package com.gigamog.herostory.events;

import com.gigamog.herostory.enums.Months;
import com.gigamog.herostory.enums.Weathers;

public class Event {

    private String name;
    private Months month;
    private int dayOfMonth;
    private Weathers weather;

    private Event nextEvent;

    public Event(String name, Months month, int day, Event next) {
        this.name = name;
        this.month = month;
        this.dayOfMonth = day;
        this.nextEvent = next;
    }

}
