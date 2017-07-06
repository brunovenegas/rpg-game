package com.example.bruno.rpg_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /**
     * View of the main game view
     */
    ImageView mMainGameView;
    /**
     * ImageView of the character sprite
     */
    ImageView mCharacterSprite;
    /**
     * ImavieView of the directional pad
     */
    ImageView mVirtualDPad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideNavigationBar();
        initializeVariables();
        loadAssets();
    }

    private void initializeVariables() {
        mMainGameView = (ImageView) findViewById(R.id.rpgMainView);
        mCharacterSprite = (ImageView) findViewById(R.id.characterSprite);
        mVirtualDPad = (ImageView) findViewById(R.id.virtualDPad);
    }

    private void loadAssets() {
        mCharacterSprite.setImageResource(R.drawable.rpg_character);
        mVirtualDPad.setImageResource(R.drawable.virtual_dpad);

    }

    private void hideNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
