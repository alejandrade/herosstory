package com.gigamog.herostory.dto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public abstract class SavingContext {
    final Preferences preferences = Gdx.app.getPreferences("herosstoryPreferences");

    public abstract void save();

}
