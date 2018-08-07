package com.gigamog.herostory.InputProcessing;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InputService {

    private final GlobalControllerListener globalControllerListener;
    private final Map<Integer, ConListener> listenerArrayList = new HashMap<>();

    /**
     * we pass in the first controllable object, if it's the first time this
     * runs everyone controller will be able to control it.
     * Once the first actions happens, that controller becomes the main controller
     * @param controllable
     */
    public InputService(Controllable controllable){
        globalControllerListener = new GlobalControllerListener(setMainController());
        ConListener conListener = new ConListener(controllable, globalControllerListener);
        this.listenerArrayList.put(1, conListener);
        Controllers.addListener(conListener);
    }

    /**
     * we can reset the main controller to a different controller
     * @param controller
     */
    public void setMainController(Controller controller){
        // if first actions hasn't happened we clear controllers, else we just set it
        if (!globalControllerListener.getFirstActionHappened()) {
            Controllers.clearListeners();
        }

        ConListener conListener = listenerArrayList.get(1);
        conListener.setController(controller);
    }

    /**
     * we set second control and choose the controller
     * @param controller
     * @param controllable
     */
    public void setSecondController(Controller controller, Controllable controllable){
        ConListener conListener = new ConListener(controllable, globalControllerListener);
        conListener.setController(controller);
        listenerArrayList.put(2, conListener);
    }

    private Consumer<Controller> setMainController() {
        return (Controller controller) -> {
            setMainController(controller);
        };
    }

    private void log(String message){
        Gdx.app.log(this.getClass().getName(), message);
    }

}
