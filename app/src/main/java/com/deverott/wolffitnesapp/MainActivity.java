package com.deverott.wolffitnesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 3000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView logo, titulo;
    TextView owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        doFirts();

    }

    private void doFirts(){
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Views
        logo = findViewById(R.id.logo_iv);
        titulo = findViewById(R.id.tittle_iv);
        owner = findViewById(R.id.owner_tv);

        //StartAnimations
        logo.setAnimation(topAnim);
        titulo.setAnimation(topAnim);
        owner.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo, "logo_transition");
                pairs[1] = new Pair<View, String>(titulo, "titulo_transition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
                finish();
            }
        }, SPLASH_SCREEN);

    }

    //

}