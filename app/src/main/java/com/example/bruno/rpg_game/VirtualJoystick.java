package com.example.bruno.rpg_game;

// Handles all the joystick mechanics, acts as joystick controller
// Gets info from MyGLSurfaceView, sends appropriate info to MyGLRenderer to draw joystick
public class VirtualJoystick {

    Triangle myTriangle;

    public VirtualJoystick() {

        myTriangle = new Triangle();


    }

    public void draw(float xCoord, float yCoord) {
        System.out.println("I'M TINY RICK");
        myTriangle.draw();

    }


}
