package com.gigamog.herostory.dto;

import lombok.Data;

@Data
public class PlayerDto {
    public static final String FIRST_NAME = "playerFirstName";
    public static final String LAST_NAME = "playerLastName";
    public static final String LEVEL = "playerLevel";
    public static final String ID = "playerId";

    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer level;
}
