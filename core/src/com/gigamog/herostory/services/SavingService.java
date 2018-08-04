package com.gigamog.herostory.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.gigamog.herostory.dto.PlayerDto;

public class SavingService {

    public static final SavingService instance = new SavingService();
    private final Preferences preferences = Gdx.app.getPreferences("herosstoryPreferences");

    private SavingService(){
    }

    public static SavingService getInstance(){
        return instance;
    }

    public void savePlayerData(PlayerDto playerDto){
        preferences.putString(PlayerDto.FIRST_NAME, playerDto.getFirstName());
        preferences.putString(PlayerDto.LAST_NAME, playerDto.getLastName());
        preferences.putInteger(PlayerDto.LEVEL, playerDto.getLevel());
        preferences.putString(PlayerDto.ID, playerDto.getId());
    }

}
