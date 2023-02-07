package com.example.casting;

import java.util.Random;

public class U2 extends Rocket{
    private int cost = 120000000;

    /**
     * A constructor of U1 class to set the field parameter
     */
    public U2() {
        setCurrentWeight(18000);
        setWeightLimit(29000);
    }

    /**
     * Returns either true or false indicating if the launch was successful or not
     * base on chane of failure calculate by the specific ratio of U1 multiply by
     * the current weight divided by the weight limit of U1 Rocket
     * @return True if the random number generated is larger than the chance of failure.
     * Otherwise, False.
     */
    @Override
    public boolean launch() {
        float chanceOfFailure = (float) (0.04 * (getCurrentWeight()/getWeightLimit()));
        return chanceOfFailure <= Math.random() * 0.1;
    }

    /**
     * Returns either true or false indicating if the landing was successful or not
     * base on chane of failure calculate by the specific ratio of U1 multiply by
     * the current weight divided by the weight limit of U1 Rocket
     * @return True if the random number generated is larger than the chance of failure.
     * Otherwise, False.
     */
    @Override
    public boolean land() {
        float chanceOfFailure = (float) (0.08 * (getCurrentWeight()/getWeightLimit()));
        return chanceOfFailure <= Math.random() * 0.1;
    }

    /**
     * Returns the cost of the U1 rocket
     * @return
     */
    public int getCost() {
        return cost;
    }
}