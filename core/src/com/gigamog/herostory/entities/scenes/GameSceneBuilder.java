package com.gigamog.herostory.entities.scenes;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameSceneBuilder {


    GameScene currentScene;


    public GameSceneBuilder addActor(Actor a) {
        if (currentScene == null) {
            currentScene = new GameScene() {
            };
        }
        currentScene.addActor(a);
        return this;
    }

    public GameScene build() {
        if (currentScene == null) {
            currentScene = new GameScene() {
            };
        }
        return currentScene;
    }

}
