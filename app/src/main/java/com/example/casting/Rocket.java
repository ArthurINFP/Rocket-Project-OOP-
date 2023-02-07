package com.example.casting;

import java.util.ArrayList;

/**
 * Rocket class implementing SpaceShip interface that providing helper methods
 * This class will be extended for specific Rockets (E.g: U1 and U2)
 */
public class Rocket implements SpaceShip {
    private float weightLimit;
    private float currentWeight;
    private ArrayList<Item> myListItem = new ArrayList<>();

    /**
     * Return either true or false indicating if the Rocket launching was successful or not
     * This method will be override by the child class to return the boolean value base on
     * the actual probability of launching for that child class.
     * For now it will always return true
     * @return true to indicate the launching is successful
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Return either true or false indicating if the Rocket landing was successful or not
     * This method will be override by the child class to return the boolean value base on
     * the actual probability of landing for that child class.
     * For now it will always return true
     * @return true to indicate the landing is sucessful
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Return either true or false if the rocket have enough space to carry the item
     *
     * @param mItem contains the item weight and name
     * @return True if the current weight of the rocket plus item weight is smaller than
     * the rocket weigh limit. Otherwise, return false
     */
    @Override
    public boolean canCarry(Item mItem) {
        return currentWeight + mItem.getWeight() <= weightLimit;
    }

    /**
     * A method that add the item into the Rocket by adding the item weight into the rocket
     * current weight and the item object in the ArrayList<Item> of the Rocket
     * @param myItem
     */
    @Override
    public void carry(Item myItem) {
        currentWeight += myItem.getWeight();
        myListItem.add(myItem);
    }

    /**
     * A getter method that return the rocket weight limit
     * @return float weight limit of the Rocket
     */
    public float getWeightLimit() {
        return weightLimit;
    }

    /**
     * A setter method that will set the weight limit of the rocket by the input parameter
     * @param weightLimit contains the float value that will set the rocket weight limit
     */
    public void setWeightLimit(float weightLimit) {
        this.weightLimit = weightLimit;
    }

    /**
     * A getter method that will return the rocket current weight
     * @return float current weight of the rocket
     */
    public float getCurrentWeight() {
        return currentWeight;
    }

    /**
     * A setter method that will set the rocket current weight by the input parameter
     * @param currentWeight contains the float value that will set the rocket current weight
     */
    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    /**
     * A getter method that will return the ArrayList of item that carried by the Rocket
     * @return ArrayList<Item> contains items
     */
    public ArrayList<Item> getMyListItem() {
        return myListItem;
    }

    /**
     * A setter method that will set the ArrayList of item that carried by the Rocket
     * @param myListItem contains an ArrayList of items that will load into the rocket
     */
    public void setMyListItem(ArrayList<Item> myListItem) {
        this.myListItem = myListItem;
    }
}
