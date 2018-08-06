package com.gigamog.herostory.entities.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public abstract class GameScene {

    private Stage stage;
    private ArrayList<Actor> actors = new ArrayList<Actor>();


    public abstract void setUp();


    public void addActor(Actor a) {
        actors.add(a);
    }


    public void startScene(Viewport vp, Batch b) {
        setUp();

        stage = new Stage(vp, b);
        for (Actor a : actors) {
            stage.addActor(a);
        }
    }

    public void cleanUpScene() {
        dispose();
    }


    public void resizeScene(int width, int height) {
        stage.getViewport().update(width, height);
    }


    public void act(float delta) {
        stage.act(delta);
    }

    public void draw() {
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }

}
