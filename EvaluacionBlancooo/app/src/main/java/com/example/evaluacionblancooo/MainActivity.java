package com.example.evaluacionblancooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText user, pwd;

    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = findViewById(R.id.tv_Error);

        user = findViewById(R.id.pt_Usuario);
        pwd = findViewById(R.id.pt_Contraseña);

        login = findViewById(R.id.btn_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
    }
    public void ingresar(){
        String usuario = user.getText().toString();
        String pass = pwd.getText().toString();

        String usuarioValido = "Usuar1";
        String passValido = "Contras1";

        int numErrores = 4;

        if(usuario.equals(usuarioValido) && pass.equals(passValido)){
            loginCorrecto();
        }
        if(!usuario.equals(usuarioValido) && !pass.equals(passValido)){
            int numeroErrores = numErrores - 1;
            error.setText("Te quedan " + numeroErrores + " intentos");
        }

        if (numErrores == 0){
            login.setVisibility(View.INVISIBLE);
        }
    }

    private void loginCorrecto(){
        Toast loginCorrecto = Toast.makeText(getApplicationContext(), "¡Logueado Correctamente!", Toast.LENGTH_SHORT);
        loginCorrecto.setGravity(Gravity.CENTER, 0, 0);
        loginCorrecto.show();

        Intent ConContrIgual = new Intent(getApplicationContext(), ConContrIgual.class);
        if(getIntent().resolveActivity(getPackageManager()) != null){
            startActivity(ConContrIgual);
        }
    }
}