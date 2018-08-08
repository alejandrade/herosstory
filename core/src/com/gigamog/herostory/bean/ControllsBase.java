package com.gigamog.herostory.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ControllsBase {
    // default values
    private int a = 1;
    private int b = 2;
    private int x = 3;
    private int y = 4;
    private int leftBumper = 5;
    private int rightBumper = 6;
    private int back = 7;
    private int start = 8;
    private int leftStick = 9;
    private int rightStick = 10;
}
