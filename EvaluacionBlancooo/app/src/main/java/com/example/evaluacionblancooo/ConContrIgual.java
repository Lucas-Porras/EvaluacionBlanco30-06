package com.example.evaluacionblancooo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConContrIgual extends AppCompatActivity {
    EditText pwdActual, pwdNueva;
    Button actualnueva;
    View bien, mal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_contr_igual);

        bien = findViewById(R.id.img_Bien);
        mal = findViewById(R.id.img_Mal);

        pwdActual = findViewById(R.id.tv_pwdActual);
        pwdNueva = findViewById(R.id.tv_pwdNueva);

        actualnueva = findViewById(R.id.btn_ActualNueva);
        actualnueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualNueva();
            }
        });
    }
    public void actualNueva(){
        String passActual = pwdActual.getText().toString();
        String passNueva = pwdNueva.getText().toString();
         //bien.setVisibility(View.INVISIBLE);

        if(passActual.equals(passNueva)){
            if(passNueva.length() < 8 && passActual.length() < 8){
                if(passNueva.matches("[A-Z]*") == true){
                    if(passNueva.matches("[0-9]*") == true){
                        bien.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
        else{
            bien.setVisibility(View.INVISIBLE);
        }
    }
}