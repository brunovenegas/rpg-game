package com.example.bruno.rpg_game;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by venegb1 on 1/21/2016.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 Context
        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);
    }
}
