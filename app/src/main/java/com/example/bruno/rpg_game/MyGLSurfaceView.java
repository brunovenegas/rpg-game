package com.example.bruno.rpg_game;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

// Surface view to display/handle touch events
public class MyGLSurfaceView extends GLSurfaceView {

    // Renderer
    private MyGLRenderer mRenderer;

    // Touch Coordinates
    float mCoordinateX = 0;
    float mCoordinateY = 0;

    SurfaceHolder surfaceHolder;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 3.0 Context
        setEGLContextClientVersion(2);
        setRenderer();
        setRenderMode(RENDERMODE_WHEN_DIRTY);

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

        mRenderer.setMotionEvent(motionEvent.getAction(), true);

        switch( motionEvent.getAction() ) {
            case MotionEvent.ACTION_DOWN:
                /*
                * Send coordinate values and action event to renderer
                * Renderer will then draw the joystick in touched coordinate
                * along with redrawing the screen/sprites
                */
                mRenderer.setCoordinates(mCoordinateX, mCoordinateY);
                requestRender();
                break;
            case MotionEvent.ACTION_MOVE:
                /*
                * Send coordinates to renderer to do appropriate drawing
                */
                break;
            case MotionEvent.ACTION_UP:
                /*
                * Make sure to have joystick disappear
                */
                break;
        }
        return true;
    }

}
