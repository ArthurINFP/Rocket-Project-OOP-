package com.example.casting;

// Item class representing an item that will be carried by rocket
public class Item {
    private float weight;
    private String name;

    /**
     * The Constructor of the item class that set weight and name of the item
     * @param weight contains the float weight of the item
     * @param name contains the String name of the item
     */
    public Item(float weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    /**
     * A getter methods that return the weight of the item
     * @return float weight of the item
     */
    public float getWeight() {
        return weight;
    }
    /**
     * A setter method that take a float and set the weight of the item
     * @param weight contain the weight value of the item
    */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * A getter method that return the name of the item
     * @return String name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * A setter method that take a String and set name of the item
     * @param name contain the String name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

}
