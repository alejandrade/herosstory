package com.gigamog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gigamog.herostory.entities.scenes.GameScene;
import com.gigamog.herostory.entities.scenes.TestScene;
import com.gigamog.herostory.enums.Characters;
import com.gigamog.herostory.enums.Emotions;
import com.gigamog.herostory.enums.Months;
import com.gigamog.herostory.events.Event;
import com.gigamog.herostory.events.StoryNode;
import com.gigamog.herostory.services.SceneManager;

public class MainGame extends ApplicationAdapter {

    SceneManager manager;
	
	@Override
	public void create () {

	    StoryNode testNode = new StoryNode(Characters.TEST, Emotions.ANGRY, "Hello World", null);
	    Event event = new Event("Test", Months.JAN, 1, null, testNode);

        manager = SceneManager.getSceneManager();
        manager.loadScene(new TestScene());

	}

	@Override
	public void resize(int width, int height) {
        //manager.resizeScene(width,height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manager.actScene(Gdx.graphics.getDeltaTime());
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
