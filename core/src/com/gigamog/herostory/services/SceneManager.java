package com.gigamog.herostory.services;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gigamog.herostory.entities.scenes.GameScene;

public class SceneManager {
    /*
    ---- SINGLETON CODE.
    TODO: make thread safe.
     */
    private static SceneManager sceneManager;
    private SceneManager() {

    }

    private Batch batch;

    public static SceneManager getSceneManager() {
        if (sceneManager == null) {
            sceneManager = new SceneManager();
            sceneManager.batch = new SpriteBatch();
        }
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

        scene.startScene(new ScreenViewport(), batch);
        currentScene = scene;
    }

    public void resizeScene(int width, int height) {
        if (currentScene!= null)
            currentScene.resizeScene(width, height);
    }

    public void actScene(float delta) {
        if (currentScene != null)
            currentScene.act(delta);
        else {
            System.out.println("SCENE NULL");
        }
    }
    public void drawScene() {
        if (currentScene != null)
            currentScene.draw();
    }

    public void disposeScene() {
        if (currentScene != null)
            currentScene.dispose();
    }

}
