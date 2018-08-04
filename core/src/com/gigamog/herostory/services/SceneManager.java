package com.gigamog.herostory.services;

import com.gigamog.herostory.entities.scenes.IScene;

public class SceneManager {
    /*
    ---- SINGLETON CODE.
    TODO: make thread safe.
     */
    private static SceneManager sceneManager;
    private SceneManager() {

    }
    public SceneManager getSceneManager() {
        if (sceneManager == null)
            sceneManager = new SceneManager();
        return sceneManager;
    }
    /*
    -----------
     */


    IScene currentScene;

    public void loadScene(IScene scene) {

        if (currentScene != null)
            currentScene.cleanUpScene();
        currentScene = null;

        scene.startScene();
        currentScene = scene;
    }



}
