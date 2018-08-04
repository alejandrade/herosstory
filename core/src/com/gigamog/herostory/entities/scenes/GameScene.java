package com.gigamog.herostory.entities.scenes;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public abstract class GameScene {

    private Stage stage = new Stage(new ScreenViewport());



    public void addActor(Actor a) {
        stage.addActor(a);
        stage = new Stage();
    }


    public void startScene() {
        //stage = new Stage();
    }

    public void cleanUpScene() {

    }


    public void act() {
        stage.act();
    }

    public void draw() {
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }

}
