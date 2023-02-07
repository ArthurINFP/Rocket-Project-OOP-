package com.example.casting;

import android.content.ClipData;

// Interface Spaceship contains methods that will be implemented by Rocket
public interface SpaceShip {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item myItem);
    public void carry(Item myItem);
}
