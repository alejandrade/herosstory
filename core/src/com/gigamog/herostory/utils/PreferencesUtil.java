package com.gigamog.herostory.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PreferencesUtil {

    private static final String PREFERENCE_NAME = "herosstoryPreferences";

    public static Preferences getPreference(){
        return Gdx.app.getPreferences(PREFERENCE_NAME);
    }
}
