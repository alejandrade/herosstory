package com.gigamog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Stage stage;
	
	@Override
	public void create () {

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		batch = new SpriteBatch();
		img = new Texture("core/assets/badlogic.jpg");


	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width,height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		stage.dispose();
	}

	/*

	I am making a change to test pull request
	 */

}
