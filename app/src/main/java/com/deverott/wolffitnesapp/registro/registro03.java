package com.deverott.wolffitnesapp.registro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.deverott.wolffitnesapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.deverott.wolffitnesapp.login;

public class registro03 extends AppCompatActivity {

    //Variables
    private String email ="", pass="", wpp, name, lastName, date, height;
    ProgressDialog progressDialog;

    /**
     * Variables de firebase
     */

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro03);
        getWindow().setStatusBarColor(Color.parseColor("#2FBED6"));
        doFirts();

    }

    private void doFirts(){

        //Obteniendo los datos del activity registro02.java
        email = getIntent().getStringExtra("email");
        pass = getIntent().getStringExtra("pass");
        wpp = getIntent().getStringExtra("wpp");
        name = getIntent().getStringExtra("name");
        lastName = getIntent().getStringExtra("lastName");
        date = getIntent().getStringExtra("date");
        height = getIntent().getStringExtra("height");

    }

    //Obtener la fecha actual
    private String getDate(){
        Date getdate = new Date();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String startDate = ""+format.format(getdate);
        return startDate;
    }

    public void registerUserClick(View view){

        createNewAccount(email, pass);

    }

    /**
     * Método para guardar en la BD la información del usuario
     */
    private void storeNewUser(String role){
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");
        String userEmail = email.split("@")[0];

        //Referencia a la clase donde guardo los datos del usuario
        userData data = new userData(name, lastName, email, pass, wpp, date, role, height, "On", getDate());
        reference.child(userEmail).setValue(data);
    }

    /**
     * Método para registrar usuario con correo y contraseña
     */

    private void createNewAccount(String em, String pa){
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.show_progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mAuth.createUserWithEmailAndPassword(em, pa)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            storeNewUser("customer");
                            progressDialog.dismiss();
                            showLogin();
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(registro03.this,
                                    "Usuario no registrado", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private void showLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
        finish();
    }


}