package com.example.casting;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Similation {
    private Context myContext;

    /**
     * A Constructor that provide Context for the all the methods in this class (if one is required)
     * which is stored in this class Field
     * @param myContext
     */
    public Similation(Context myContext) {
        this.myContext = myContext;
    }

    /**
     * A method that read the file that contains all the items with their names and weights which will
     * be loaded into the Rocket later on
     * Each line contain a name and a weight value separated by "=" character
     * @param filename String name of the file
     * @return ArrayList<Item> that contains all the items in the file
     */
    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> cargo = new ArrayList<Item>();
        BufferedReader myStream;
        try {
            myStream = new BufferedReader(new InputStreamReader(myContext.getAssets().open(filename), "UTF-8"));
            String line;
            while ((line = myStream.readLine()) != null) {
                String[] item = line.split("=");
                cargo.add(new Item(Float.parseFloat(item[1]), item[0]));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cargo;
    }

    /**
     * A methods that load all items from input ArrayList<Item> into the U1 rockets
     * The methods will load each items into a rocket and check if there is space left
     * for another items. If not, a new U1 rocket will be create and continue to carry the items
     * This loop proceed until there is no items left in the ArrayList<Item>
     * All the U1 rocket has been created and fully loaded with items will be stored and returned
     * as a ArrayList<U1> parameter
     * @param cargo contains ArrayList of items
     * @return  an ArrayList<U1> contains all the U1 Rocket that are fully loaded
     */
    public ArrayList<U1> loadU1(ArrayList<Item> cargo) {
        ArrayList<U1> myRocket = new ArrayList<>();
        U1 rocketU1 = new U1();
        for (Item i : cargo) {
            if (rocketU1.canCarry(i)) {
                rocketU1.carry(i);

            } else {
                myRocket.add(rocketU1);
                rocketU1 = new U1();
                rocketU1.carry(i);
            }
        }
        return myRocket;
    }

    /**
     * A methods that load all items from input ArrayList<Item> into the U2 rockets
     * The methods will load each items into a rocket and check if there is space left
     * for another items. If not, a new U2 rocket will be create and continue to carry the items
     * This loop proceed until there is no items left in the ArrayList<Item>
     * All the U2 rocket has been created and fully loaded with items will be stored and returned
     * as a ArrayList<U2> parameter
     * @param cargo contains ArrayList of items
     * @return  an ArrayList<U2> contains all the U2 Rocket that are fully loaded
     */
    public ArrayList<U2> loadU2(ArrayList<Item> cargo) {
        ArrayList<U2> myRocket = new ArrayList<>();
        U2 rocketU2 = new U2();
        for (Item i : cargo) {
            if (rocketU2.canCarry(i)) {
                rocketU2.carry(i);

            } else {
                myRocket.add(rocketU2);
                rocketU2 = new U2();
                rocketU2.carry(i);
            }
        }
        return myRocket;
    }

    /**
     * The method will calculate the total cost of launching and landing of every Rockets
     * from the ArrayList<Rocket> input parameter.
     * The loop will run through the ArrayList<Rocket> as they try to launching and landing
     * the Rocket while adding the Rocket cost to the total cost
     * If this process is success, the index will increase by 1 and the next rocket will be tested.
     * Otherwise, when the rocket false the process, the cost will be added and that rocket will be
     * tested again.
     * @param myRocket
     * @return
     */
    public int runSimulation(ArrayList<Rocket> myRocket) {
        int totalCost = 0;
        int i = 0;
        while (i < myRocket.size() - 1) {
            if ((myRocket.get(i) instanceof U1)) {
                totalCost += ((U1) myRocket.get(i)).getCost();
            } else {
                totalCost += ((U2) myRocket.get(i)).getCost();
            }
            if ((myRocket.get(i).launch()) && (myRocket.get(i).land())) {
                i += 1;
            }

        }
        return totalCost;
    }
}
