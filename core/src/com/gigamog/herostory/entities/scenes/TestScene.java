package com.gigamog.herostory.entities.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestScene extends GameScene {

    @Override
    public void setUp() {
        Texture img = new Texture("core/assets/badlogic.jpg");
        Image i = new Image(img);
        i.setPosition(0,0);

        addActor(i);
    }


}
