package com.gigamog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gigamog.herostory.entities.scenes.GameScene;
import com.gigamog.herostory.entities.scenes.GameSceneBuilder;
import com.gigamog.herostory.services.SceneManager;

public class MainGame extends ApplicationAdapter {
	Texture img;

    SceneManager manager;
	
	@Override
	public void create () {

        manager = SceneManager.getSceneManager();


        img = new Texture("core/assets/badlogic.jpg");
        Image i = new Image(img);
        i.setPosition(0,0);
        GameScene startingScene = new GameSceneBuilder()
                .addActor(i)
                .build();

        manager.loadScene(startingScene);

	}

	@Override
	public void resize(int width, int height) {
		//stage.getViewport().update(width,height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manager.actScene();
        manager.drawScene();
	}
	
	@Override
	public void dispose () {

		manager.disposeScene();
	}

	/*

	I am making a change to test pull request
	 */

}
