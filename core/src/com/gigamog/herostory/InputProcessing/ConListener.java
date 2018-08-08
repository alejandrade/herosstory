package com.gigamog.herostory.InputProcessing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.gigamog.herostory.bean.ControllerBean;
import com.gigamog.herostory.bean.ControllsBase;
import com.gigamog.herostory.bean.KeyboardBean;
import com.gigamog.herostory.services.PreferenceLoaderService;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ConListener implements ControllerListener, InputProcessor {
    private static final Set<ControllerButton> buttonsPressed = new HashSet<>();
    private static final Set<Integer> wasdButtons = new HashSet<>();

    private static final Consumer<ControllerButton> addToButtonsPressed =
            (ControllerButton button)->buttonsPressed.add(button);
    private static final Consumer<ControllerButton> removeFromButtonsPressed =
            (ControllerButton button)->buttonsPressed.remove(button);

    @Setter
    private Controllable controllable;
    private Controller controller;
    private ControllerBean controllerBean;
    private KeyboardBean keyboardBean;


    private final GlobalControllerListener globalControllerListener;

    public ConListener(Controllable controllable, GlobalControllerListener globalControllerListener) {
        this.controllable = controllable;
        this.globalControllerListener = globalControllerListener;
        PreferenceLoaderService preferenceLoaderService = PreferenceLoaderService.getInstance();
        controllerBean = preferenceLoaderService.getControllerMapping();
        keyboardBean = preferenceLoaderService.getKeyboardMapping();
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
        globalControllerListener.actionHappened(controller);
        consumeButton(controllerBean, buttonCode, addToButtonsPressed);
        controllable.buttonChange(buttonsPressed);
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        globalControllerListener.actionHappened(controller);
        consumeButton(controllerBean, buttonCode, removeFromButtonsPressed);
        controllable.buttonChange(buttonsPressed);
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


    @Override
    public boolean keyDown(int keycode) {
        wasdButtons.add(keycode);
        wasdMovements();
        consumeButton(keyboardBean, keycode, addToButtonsPressed);

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        wasdButtons.remove(keycode);
        wasdMovements();
        consumeButton(keyboardBean, keycode, removeFromButtonsPressed);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    private void consumeButton(ControllsBase controllsBase, Integer buttonClicked, Consumer<ControllerButton> controllerButtonConsumer){
        if(buttonClicked == controllsBase.getA()){
            controllerButtonConsumer.accept(ControllerButton.a);
        }else if(buttonClicked == controllsBase.getB()){
            controllerButtonConsumer.accept(ControllerButton.b);
        }else if(buttonClicked == controllsBase.getBack()){
            controllerButtonConsumer.accept(ControllerButton.back);
        }else if(buttonClicked == controllsBase.getLeftBumper()){
            controllerButtonConsumer.accept(ControllerButton.leftBumper);
        }else if (buttonClicked == controllsBase.getLeftStick()){
            controllerButtonConsumer.accept(ControllerButton.leftStick);
        }else if (buttonClicked == controllsBase.getRightBumper()){
            controllerButtonConsumer.accept(ControllerButton.rightBumper);
        }else if(buttonClicked == controllsBase.getRightStick()){
            controllerButtonConsumer.accept(ControllerButton.rightStick);
        }else if(buttonClicked == controllsBase.getStart()){
            controllerButtonConsumer.accept(ControllerButton.start);
        }else if(buttonClicked == controllsBase.getX()){
            controllerButtonConsumer.accept(ControllerButton.x);
        }else if(buttonClicked == controllsBase.getY()){
            controllerButtonConsumer.accept(ControllerButton.y);
        }
    }
    private void wasdMovements(){
        if(wasdButtons.containsAll(Arrays.asList(Input.Keys.W, Input.Keys.D))
                && !wasdButtons.contains(Input.Keys.S) && !wasdButtons.contains(Input.Keys.A)){
            controllable.dpad(PovDirection.northEast);
            return;
        }
        if(wasdButtons.containsAll(Arrays.asList(Input.Keys.W, Input.Keys.A))
                && !wasdButtons.contains(Input.Keys.S) && !wasdButtons.contains(Input.Keys.D)){
            controllable.dpad(PovDirection.northWest);
            return;

        }
        if(wasdButtons.containsAll(Arrays.asList(Input.Keys.S, Input.Keys.A))
                && !wasdButtons.contains(Input.Keys.W) && !wasdButtons.contains(Input.Keys.D)){
            controllable.dpad(PovDirection.southWest);
            return;

        }
        if(wasdButtons.containsAll(Arrays.asList(Input.Keys.S, Input.Keys.D))
                && !wasdButtons.contains(Input.Keys.W) && !wasdButtons.contains(Input.Keys.A)){
            controllable.dpad(PovDirection.southEast);
            return;
        }

        if(wasdButtons.contains(Input.Keys.W) && !wasdButtons.contains(Input.Keys.S)){
            controllable.dpad(PovDirection.north);
            return;
        }
        if(wasdButtons.contains(Input.Keys.D) && !wasdButtons.contains(Input.Keys.A)){
            controllable.dpad(PovDirection.east);
            return;
        }
        if(wasdButtons.contains(Input.Keys.S) && !wasdButtons.contains(Input.Keys.W)){
            controllable.dpad(PovDirection.south);
            return;
        }
        if(wasdButtons.contains(Input.Keys.A) && !wasdButtons.contains(Input.Keys.D)){
            controllable.dpad(PovDirection.west);
            return;
        }

    }
    private void log(String message){
        Gdx.app.log(this.getClass().getName(), message);
    }
}
