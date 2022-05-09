package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Asiganar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Asiganar = findViewById(R.id.Alarma);

        Asiganar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                EstablecerAlamarma("Tarea de clase INTENTS", 9, 36);
            }
        });
    }

    public void EstablecerAlamarma(String Mensaje, int Hora, int Minutos){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, Mensaje)
                .putExtra(AlarmClock.EXTRA_HOUR, Hora)
                .putExtra(AlarmClock.EXTRA_MINUTES, Minutos);

        if (intent.resolveActivity(getPackageManager())!=null){

            startActivity(intent);

        }
    }
}