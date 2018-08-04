package com.gigamog.herostory.services;

public class SavingService {

    public static final SavingService instance = new SavingService();


    private SavingService(){
    }

    public static SavingService getInstance(){
        return instance;
    }




}
