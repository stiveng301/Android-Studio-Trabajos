package com.example.cilodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView TextEmail, TextPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextEmail = findViewById(R.id.Correo);
        TextPass = findViewById(R.id.Clave);

        String EMAIL = getIntent().getStringExtra("Email");
        String PASS = getIntent().getStringExtra("Clave");

        TextEmail.setText(EMAIL);
        TextPass.setText(PASS);
    }
}