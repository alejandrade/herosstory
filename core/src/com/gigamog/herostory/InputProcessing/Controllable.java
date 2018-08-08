package com.gigamog.herostory.InputProcessing;

import com.badlogic.gdx.controllers.PovDirection;

import java.util.Set;

public interface Controllable {
    /**
     * this can only be one direction
     * @param direction
     */
    void dpad(PovDirection direction);

    /**
     * can only be one axis
     * @param axis
     * @param value
     */
    void leftJoyStick(Integer axis, Float value);
    void rightJoyStick(Integer axis, Float value);
    void leftBumper(Float value);
    void rightBumper(Float value);
    void buttonChange(Set<ControllerButton> buttonsPressed);
    void lettersTyped(Character character);
}
