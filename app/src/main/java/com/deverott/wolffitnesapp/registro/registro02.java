package com.deverott.wolffitnesapp.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.deverott.wolffitnesapp.R;

import java.util.Calendar;

public class registro02 extends AppCompatActivity {

    //Variables
    private int dia, mes, anio;
    private String wpp, email, pass;

    EditText fecha, name, lastname, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro02);
        getWindow().setStatusBarColor(Color.parseColor("#2FBED6"));
        doFirts();
    }

    private Boolean validateName(){
        String val = name.getText().toString();
        if(val.isEmpty()){
            name.setError("Campo Obligatorio");
            return false;
        }else{
            name.setError(null);
            return true;
        }
    }

    private Boolean validateLastName(){
        String val = lastname.getText().toString();
        if(val.isEmpty()){
            lastname.setError("Campo Obligatorio");
            return false;
        }else{
            lastname.setError(null);
            return true;
        }
    }

    private Boolean validateDate(){
        String val = fecha.getText().toString();
        if(val.isEmpty()){
            fecha.setError("Campo Obligatorio");
            return false;
        }else{
            fecha.setError(null);
            return true;
        }
    }

    private Boolean validateHeight(){
        String val = height.getText().toString();
        if(val.isEmpty()){
            height.setError("Campo Obligatorio");
            return false;
        }else{
            height.setError(null);
            return true;
        }
    }

    private void doFirts(){
        fecha = findViewById(R.id.date_et);
        name = findViewById(R.id.name_et);
        lastname = findViewById(R.id.last_name_et);
        height = findViewById(R.id.height_et);
        wpp = getIntent().getStringExtra("wpp");
        email = getIntent().getStringExtra("email");
        pass = getIntent().getStringExtra("pass");
    }

    public void chooseDate(View view){
        final Calendar calendar= Calendar.getInstance();
        dia= calendar.get(Calendar.DAY_OF_MONTH);
        mes= calendar.get(Calendar.MONTH);
        anio= calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, dia, mes, anio);
        datePickerDialog.show();

    }

    public void showRegistro03(View view){
        if (validateName() & validateLastName() & validateDate() & validateHeight()){
            String nombre = name.getText().toString();
            String apellido = lastname.getText().toString();
            String date = fecha.getText().toString();
            String altura = height.getText().toString();
            Intent intent = new Intent(this, registro03.class);
            intent.putExtra("email", email);
            intent.putExtra("pass", pass);
            intent.putExtra("wpp", wpp);
            intent.putExtra("name", nombre);
            intent.putExtra("lastName", apellido);
            intent.putExtra("date", date);
            intent.putExtra("height", altura);
            startActivity(intent);
            finish();
        }

    }





}