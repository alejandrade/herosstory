package com.gigamog.herostory.entities.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestActor extends Image {

    public TestActor(Texture tex) {
        super(tex);



    }


    @Override
    public void act(float delta) {

        if (Gdx.input.isButtonPressed(Input.Keys.A)) {
            System.out.println("PRESSING A");
        }

    }

}
