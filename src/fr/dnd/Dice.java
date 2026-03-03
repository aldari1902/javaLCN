package fr.dnd;

import java.util.Random;

public class Dice {

    Random rand = new Random();

    public int roll(int maxValue) {
        int result = rand.nextInt(maxValue) + 1;
        return result;
    }
}
