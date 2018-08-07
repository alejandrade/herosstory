package com.gigamog.herostory.InputProcessing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import lombok.Setter;

public class ConListener implements ControllerListener {

    @Setter
    private Controllable controllable;
    private Controller controller;


    private final GlobalControllerListener globalControllerListener;

    public ConListener(Controllable controllable, GlobalControllerListener globalControllerListener) {
        this.controllable = controllable;
        this.globalControllerListener = globalControllerListener;
    }

    @Override
    public void connected(Controller controller) {
        log(controller.getName() + " connected");
    }

    @Override
    public void disconnected(Controller controller) {
        log(controller.getName() + " disconected");

    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        log(buttonCode + " button down");
        controllable.buttonPressed(buttonCode);
        globalControllerListener.actionHappened(controller);
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        log(buttonCode + " button up");
        controllable.buttonRaised(buttonCode);
        globalControllerListener.actionHappened(controller);
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        globalControllerListener.actionHappened(controller);

        if (axisCode < 2){
            controllable.leftJoyStick(axisCode, value);
            log(axisCode + "left joy stick " + value);
        }else if(axisCode < 4){
            controllable.rightJoyStick(axisCode, value);
            log(axisCode + "right joy stick " + value);
        }else if(axisCode == 4 &&  value >= 0 && value <= 1f){
            controllable.leftBumper(value);
            log(axisCode + " left bumper " + value);
        }else if(axisCode == 4 && value >= -1f && value <= 0f){
            controllable.rightBumper(value);
            log(axisCode + " right bumper " + value);
        }
        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        globalControllerListener.actionHappened(controller);
        log(povCode + " pov code moved " + value + " to value");
        controllable.dpad(value);
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        globalControllerListener.actionHappened(controller);
        log(sliderCode + " x slider " + value + " to value");
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        globalControllerListener.actionHappened(controller);
        log(sliderCode + " x slider " + value + " to value");
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        log(accelerometerCode + " accelerometer " + value + " to value");
        return false;
    }


    public void setController(Controller controller) {
        this.controller = controller;
        controller.addListener(this);
    }

    private void log(String message){
        Gdx.app.log(this.getClass().getName(), message);
    }
}
