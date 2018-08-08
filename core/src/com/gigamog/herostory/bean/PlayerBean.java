package com.gigamog.herostory.bean;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Builder
public class PlayerBean {
    public static final String FIRST_NAME = "playerFirstName";
    public static final String LAST_NAME = "playerLastName";
    public static final String LEVEL = "playerLevel";

    private final String firstName;
    private final String lastName;
    private final Integer level;

}
