package com.company.Game;

import java.util.Random;

public class Dice {
    public Dice() { }

    public int diceRoll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
