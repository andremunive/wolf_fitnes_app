package com.deverott.wolffitnesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.deverott.wolffitnesapp.registro.registro01;

public class login extends AppCompatActivity {

    //Variables
    EditText email, pass;
    ImageView logo, titulo;
    Button login;
    TextView forgot, registro, owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(Color.parseColor("#2FBED6"));

        doFirts();
    }

    private void doFirts(){
        logo = findViewById(R.id.logo_iv);
        titulo = findViewById(R.id.tittle_iv);
        email = findViewById(R.id.email_et);
        pass = findViewById(R.id.pass_et);
        login = findViewById(R.id.login_b);
        forgot = findViewById(R.id.forgot_pass_tv);
        registro = findViewById(R.id.registro_tv);
        owner = findViewById(R.id.owner_tv);

    }



    public void showRegistro(View view){
        Intent intent = new Intent(this, registro01.class);

        Pair[] pairs = new Pair[6];

        pairs[0] = new Pair<View, String>(logo, "logo_transition");
        pairs[1] = new Pair<View, String>(titulo, "titulo_transition");
        pairs[2] = new Pair<View, String>(email, "email_transition");
        pairs[3] = new Pair<View, String>(pass, "pass_transition");
        //pairs[4] = new Pair<View, String>(forgot, "forgot_transition");
        pairs[4] = new Pair<View, String>(login, "go_transition");
        //pairs[6] = new Pair<View, String>(registro, "singup_transition");
        pairs[5] = new Pair<View, String>(owner, "owner_transition");

        //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(login.this, pairs);
        startActivity(intent);
    }

    public void loginClick(View view){
        showHome();
    }

    private void showHome(){
        Intent intent = new Intent(this, customerHome.class);
        startActivity(intent);
    }
}