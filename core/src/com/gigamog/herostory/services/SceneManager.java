package com.gigamog.herostory.services;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.gigamog.herostory.entities.scenes.GameScene;

public class SceneManager {
    /*
    ---- SINGLETON CODE.
    TODO: make thread safe.
     */
    private static SceneManager sceneManager;
    private SceneManager() {

    }
    public static SceneManager getSceneManager() {
        if (sceneManager == null)
            sceneManager = new SceneManager();
        return sceneManager;
    }
    /*
    -----------
     */


    GameScene currentScene;

    public void loadScene(GameScene scene) {

        if (currentScene != null)
            currentScene.cleanUpScene();
        currentScene = null;

        scene.startScene();
        currentScene = scene;
    }

    public void actScene() {
        if (currentScene != null)
            currentScene.act();
    }
    public void drawScene() {
        if (currentScene == null)
            currentScene.draw();
    }

    public void disposeScene() {
        if (currentScene != null)
            currentScene.dispose();
    }

}
