package com.gigamog.herostory.dto;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Builder
public class PlayerDto {
    public static final String FIRST_NAME = "playerFirstName";
    public static final String LAST_NAME = "playerLastName";
    public static final String LEVEL = "playerLevel";

    private final String firstName;
    private final String lastName;
    private final Integer level;

}
