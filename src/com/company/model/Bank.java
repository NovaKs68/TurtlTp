package com.company.model;

public class Bank {
    private int greenPawn;

    private Bank() {
        greenPawn = 0;
    }

    private static Bank INSTANCE = new Bank();

    public static Bank getInstance() {
        return INSTANCE;
    }

    public int getGreenPawn() {
        return greenPawn;
    }

    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }
}
