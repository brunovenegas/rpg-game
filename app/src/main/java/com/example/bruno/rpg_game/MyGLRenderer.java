package com.example.bruno.rpg_game;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Renderer to control all of the graphics on the screen
// Will only draw
public class MyGLRenderer implements GLSurfaceView.Renderer {

    // Touch Coordinates
    float mCoordinateX = 0;
    float mCoordinateY = 0;

    // Motion Event
    int mMotionEvent;

    // Boolean to determine whether event was received from MyGLSurfaceView
    boolean mReceivedEvent = false;

    // Instance of VirtualJoystick
    VirtualJoystick mJoystick;

    // This only gets called once, when creating GLSurfaceView
    // Use this when when performing actions that only need to happen once
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES30.glClearColor(0.0f, 0.5f, 1.0f, 0.0f);

        mJoystick = new VirtualJoystick();
    }

    // This is called on each redraw of GLSurfaceView
    // Primary execution point for drawing graphics
    public void onDrawFrame(GL10 unused) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
        if((mMotionEvent == MotionEvent.ACTION_DOWN) && mReceivedEvent) {
            mJoystick.draw(mCoordinateX, mCoordinateY);
            mReceivedEvent = false;
        }
    }

    // This is called when GLSurfaceView's geometry changes
    // Such as size/orientation changing
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
    }

    // Sets coordinates
    public void setCoordinates(float xCoord, float yCoord) {
        mCoordinateX = xCoord;
        mCoordinateY = yCoord;
    }

    public void setMotionEvent(int motionEvent, boolean receivedEvent) {
        mMotionEvent = motionEvent;
        mReceivedEvent = receivedEvent;
    }

    public static int loadShader(int type, String shaderCode) {
        int shader = GLES30.glCreateShader(type);
        GLES30.glShaderSource(shader, shaderCode);
        GLES30.glCompileShader(shader);
        return shader;
    }

}
