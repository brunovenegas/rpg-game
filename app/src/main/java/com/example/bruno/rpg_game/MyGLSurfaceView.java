package com.example.bruno.rpg_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by venegb1 on 1/21/2016.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    // Renderer
    private MyGLRenderer mRenderer;

    // Instance of Virtual Joystick
    private VirtualJoystick mVirtualJoystick;

    // Touch Coordinates
    float mCoordinateX = 0;
    float mCoordinateY = 0;

    SurfaceHolder surfaceHolder;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 3.0 Context
        setEGLContextClientVersion(3);
        setRenderer();
        setRenderMode(RENDERMODE_WHEN_DIRTY);

        // Instance of the VirtualJoystick
        mVirtualJoystick = new VirtualJoystick(getContext());

        // Surface holder?
        surfaceHolder = getHolder();
    }

    // Set renderer for MyGLSurfaceView
    private void setRenderer() {
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        mCoordinateX = motionEvent.getX();
        mCoordinateY = motionEvent.getY();

        System.out.println("X coordinate: " + mCoordinateX);
        System.out.println("Y coordinate: " + mCoordinateY);

        switch( motionEvent.getAction() ) {
            case MotionEvent.ACTION_DOWN:
                mVirtualJoystick.run();
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("I am moving");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("I am up");
                break;
        }
        return true;
    }

}
