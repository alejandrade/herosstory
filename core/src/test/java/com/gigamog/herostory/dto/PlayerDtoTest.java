package com.gigamog.herostory.dto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.gigamog.MainGameTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerDtoTest extends MainGameTest {
    final Preferences preferences = Gdx.app.getPreferences("herosstoryPreferences");

    @Test
    public void save()  {
        PlayerDto playerDto = new PlayerDto("sd", "asdf", "sdf", 1);
        playerDto.save();
        assertEquals("sd", preferences.getString("playerId"));
        assertEquals("asdf", preferences.getString("playerFirstName"));
        assertEquals("sdf", preferences.getString("playerLastName"));
        assertEquals(1, preferences.getInteger("playerLevel"));
    }
}