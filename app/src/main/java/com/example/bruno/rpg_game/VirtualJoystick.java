package com.example.bruno.rpg_game;

import android.content.Context;
import android.view.View;

/**
 * Created by venegb1 on 1/21/2016.
 */
public class VirtualJoystick extends View implements Runnable {

    public VirtualJoystick(Context context) {
        super(context);
    }


    @Override
    public void run() {
        System.out.println("I am down in VirtualJoystick");
    }

}
