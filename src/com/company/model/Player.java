package com.company.model;

public class Player {
    private int redPawn;

    private int limitedRedPawn = 0;

    private Player() {
        redPawn = 0;
    }

    private static Player INSTANCE = new Player();

    public static Player getInstance() {
        return INSTANCE;
    }

    public int getRedPawn() {
        return redPawn;
    }

    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }

    public int getLimitedRedPawn() {
        return limitedRedPawn;
    }

    public void setLimitedRedPawn(int limitedRedPawn) {
        this.limitedRedPawn = limitedRedPawn;
    }
}
