package com.gigamog.herostory.InputProcessing;

import com.badlogic.gdx.controllers.Controller;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;


@RequiredArgsConstructor
public class GlobalControllerListener {
    @Getter
    private Boolean firstActionHappened = false;

    private final Consumer<Controller> controllerConsumer;

    public void actionHappened(Controller controller){
        if(!firstActionHappened){
            controllerConsumer.accept(controller);
        }
        firstActionHappened = true;
    }
}
