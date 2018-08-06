package com.gigamog.herostory.entities.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.gigamog.herostory.entities.actors.TestActor;

public class TestScene extends GameScene {

    @Override
    public void setUp() {
        Texture img = new Texture("core/assets/badlogic.jpg");
        TestActor i = new TestActor(img);
        i.setPosition(0,0);

        addActor(i);
    }


}
