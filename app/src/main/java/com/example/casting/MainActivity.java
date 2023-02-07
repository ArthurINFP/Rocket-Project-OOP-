package com.example.casting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Capture the Text View
        TextView mTV = findViewById(R.id.tv_testing);

        //Create a Similation class Object here
        Similation mySimp = new Similation(this);

        //Load all the text contain into these ArrayList<Item> variable
        ArrayList<Item> cargo1 = mySimp.loadItems("phase-1.txt");
        ArrayList<Item> cargo2 = mySimp.loadItems("phase-2.txt");

        //Create an ArrayList<Rocket> Object and try to load all the items from the file
        //into U1 Rockets
        ArrayList<Rocket> rocketU1 = new ArrayList<Rocket>();
        rocketU1.addAll(mySimp.loadU1(cargo1));
        rocketU1.addAll(mySimp.loadU1(cargo2));

        //Calculate the cost of launching and landing U1 Rockets
        int costU1 = mySimp.runSimulation(rocketU1);

        //Create an ArrayList<Rocket> Object and try to load all the items from the file
        //into U2 Rockets
        ArrayList<Rocket> rocketU2 = new ArrayList<Rocket>();
        rocketU2.addAll(mySimp.loadU2(cargo1));
        rocketU2.addAll(mySimp.loadU2(cargo2));

        //Calculate the cost of launching and landing U2 Rockets
        int costU2 = mySimp.runSimulation(rocketU1);

        //Display the cost of U1 and U2 Rockets
        mTV.setText(String.valueOf(costU1)+" "+String.valueOf(costU2));

    }
}