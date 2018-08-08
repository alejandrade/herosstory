package com.gigamog.herostory.services;

import com.badlogic.gdx.Preferences;
import com.gigamog.herostory.bean.ControllerBean;
import com.gigamog.herostory.bean.KeyboardBean;
import com.gigamog.herostory.bean.PlayerBean;
import com.gigamog.herostory.utils.PreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


public final class PreferenceLoaderService {

    private static PreferenceLoaderService preferenceLoaderService;
    private final Preferences preferences = PreferencesUtil.getPreference();
    private final static Gson gson = new Gson();


    private static final String PLAYER_TABLE = "playerTable";
    private static final String CONTROLLER_TABLE = "controllerTable";

    private static final Type PLAYER_DTO_LIST_TYPE = new TypeToken<List<PlayerBean>>(){}.getType();

    private PreferenceLoaderService(){

    }

    public static PreferenceLoaderService getInstance(){
        if (preferenceLoaderService == null) {
            preferenceLoaderService = new PreferenceLoaderService();
        }
        return preferenceLoaderService;
    }

    public void savePlayer(final PlayerBean playerBean){
        saveArray(playerBean, PLAYER_DTO_LIST_TYPE, PLAYER_TABLE);
    }

    public void saveController(final ControllerBean controllerBean){
        save(controllerBean, CONTROLLER_TABLE);
    }

    public ControllerBean getControllerMapping(){
        String controllerJson = preferences.getString(CONTROLLER_TABLE);
        if (controllerJson == null) {
            return new ControllerBean();
        }
        return gson.fromJson(controllerJson, ControllerBean.class);
    }

    public KeyboardBean getKeyboardMapping(){
        return new KeyboardBean();
    }

    private void save(final Object object, String key){
        String endingJson  = gson.toJson(object);
        preferences.putString(key, endingJson);
    }

    private void saveArray(final Object object, Type type, String key){
        String startingJson = preferences.getString(key);
        List list = gson.fromJson(startingJson, type);
        Optional<PlayerBean> first = list.stream().filter(inObj -> object.equals(inObj)).findFirst();
        if(first.isPresent()){
            list.remove(first.get());
        }
        list.add(object);
        String endingJson  = gson.toJson(list);
        preferences.putString(key, endingJson);
    }

}
