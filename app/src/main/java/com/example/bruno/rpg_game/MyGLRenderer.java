package com.example.bruno.rpg_game;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by venegb1 on 1/21/2016.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {

    // This only gets called once, when creating GLSurfaceView
    // Use this when when performing actions that only need to happen once
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES30.glClearColor(0.0f, 0.5f, 1.0f, 1.0f);
    }

    // This is called on each redraw of GLSurfaceView
    // Primary execution point for drawing graphics
    public void onDrawFrame(GL10 unused) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
    }

    // This is called when GLSurfaceView's geometry changes
    // Such as size/orientation changing
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
    }

}
