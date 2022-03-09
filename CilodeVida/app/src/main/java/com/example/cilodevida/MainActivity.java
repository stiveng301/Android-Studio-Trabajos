package com.example.cilodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = "Actividad Uno";
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "--OnCreate--");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "--OnStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "--OnResume--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "--OnRestart--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "--OnPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "--OnStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "--OnDestroy--");
    }

    public void SegundaPantalla(View view){

        Intent IrVista2 = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(IrVista2);

    }

}