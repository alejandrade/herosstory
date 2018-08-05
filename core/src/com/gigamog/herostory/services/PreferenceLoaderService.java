package com.gigamog.herostory.services;

import com.badlogic.gdx.Preferences;
import com.gigamog.herostory.dto.PlayerDto;
import com.gigamog.herostory.utils.PreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


public class PreferenceLoaderService {
    private final Preferences preferences = PreferencesUtil.getPreference();
    private final static Gson gson = new Gson();
    private static final String PLAYER_TABLE = "playerTable";

    public void savePlayer(final PlayerDto playerDto){
        saveArray(playerDto, new TypeToken<List<PlayerDto>>(){}.getType(), PLAYER_TABLE);
    }

    private void save(final Object object, String key){
        String endingJson  = gson.toJson(object);
        preferences.putString(key, endingJson);
    }

    private void saveArray(final Object object, Type type, String key){
        String startingJson = preferences.getString(key);
        List list = gson.fromJson(startingJson, type);
        Optional<PlayerDto> first = list.stream().filter(inObj -> object.equals(inObj)).findFirst();
        if(first.isPresent()){
            list.remove(first.get());
        }
        list.add(object);
        String endingJson  = gson.toJson(list);
        preferences.putString(key, endingJson);
    }

}
