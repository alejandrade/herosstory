package com.gigamog.herostory.dto;

import lombok.Data;

@Data
public class PlayerDto extends SavingContext {
    private static final String ID = "playerId";
    private static final String FIRST_NAME = "playerFirstName";
    private static final String LAST_NAME = "playerLastName";
    private static final String LEVEL = "playerLevel";

    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer level;

    @Override
    public void save() {
        preferences.putString(PlayerDto.ID, getId());
        preferences.putString(PlayerDto.FIRST_NAME, getFirstName());
        preferences.putString(PlayerDto.LAST_NAME, getLastName());
        preferences.putInteger(PlayerDto.LEVEL, getLevel());
    }
}
