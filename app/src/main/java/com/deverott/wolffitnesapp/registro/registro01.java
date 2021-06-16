package com.deverott.wolffitnesapp.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.deverott.wolffitnesapp.R;

public class registro01 extends AppCompatActivity {

    //Variables
    Button next;

    //EditText
    EditText wp, email, pass, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro01);
        getWindow().setStatusBarColor(Color.parseColor("#2FBED6"));

        doFirts();
    }

    /**
     * Funciones para validar los campos de texto
     */

    private Boolean validateWpp(){
        String val = wp.getText().toString();
        if(val.isEmpty()){
            wp.setError("Campo Obligatorio");
            return false;
        }else{
            if(val.length() != 10){
                wp.setError("Número Inválido");
                return false;
            }else{
                wp.setError(null);
                return true;
            }
        }
    }

    private Boolean validateEmail(){
        String val = email.getText().toString();
        String emailPATH = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            email.setError("Campo Obligatorio");
            return false;
        }else if (!val.matches(emailPATH)){
            email.setError("Email Inválido");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePass1(){
        String val = pass.getText().toString();
        if(val.isEmpty()){
            pass.setError("Campo Obligatorio");
            return false;
        }else{
            if(val.length() < 5){
                pass.setError("Contraseña Demasiado Corta");
                return false;
            }else{
                pass.setError(null);
                return true;
            }
        }
    }

    private Boolean validatePass2(){
        String val = pass2.getText().toString();
        String val2 = pass.getText().toString();
        if(val.isEmpty()){
            pass2.setError("Campo Obligatorio");
            return false;
        }else {
            if(!val.equals(val2)){
                pass2.setError("Las Contraseñas Deben Coincidir");
                return false;
            }else{
                pass2.setError(null);
                return true;
            }
        }
    }

    private void doFirts(){
        wp = findViewById(R.id.phone_et);
        email = findViewById(R.id.email_et);
        pass = findViewById(R.id.pass_et);
        pass2 = findViewById(R.id.height_et);
    }


    public void showRegistro02(View view){
        if(validateWpp() & validateEmail() & validatePass1() & validatePass2()){
            String wpp = wp.getText().toString();
            String correo = email.getText().toString();
            String contra = pass.getText().toString();
            Intent intent = new Intent(this, registro02.class);
            intent.putExtra("email", correo);
            intent.putExtra("wpp", wpp);
            intent.putExtra("pass", contra);
            startActivity(intent);
            finish();
        }else{
            return;
        }



    }


}