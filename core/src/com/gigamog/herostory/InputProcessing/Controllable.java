package com.gigamog.herostory.InputProcessing;

import com.badlogic.gdx.controllers.PovDirection;

public interface Controllable {
    void dpad(PovDirection direction);
    void leftJoyStick(Integer axis, Float value);
    void rightJoyStick(Integer axis, Float value);
    void leftBumper(Float value);
    void rightBumper(Float value);
    void buttonPressed(Integer buttonNumber);
    void buttonRaised(Integer buttonRaised);
}
