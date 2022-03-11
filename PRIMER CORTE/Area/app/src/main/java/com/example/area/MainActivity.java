package com.example.area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ladoUno,ladoDos, baseuno, alturauno;
    RadioButton rectangulo,triangulo;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ladoUno = (EditText) findViewById(R.id.valorLadoUno);
        ladoDos = (EditText) findViewById(R.id.valorLadoDos);
        rectangulo = (RadioButton) findViewById(R.id.radioAreaRectangulo);
        triangulo = (RadioButton) findViewById(R.id.radioAreaTriangulo);
        resultado = (TextView) findViewById(R.id.resultado);
        baseuno = (EditText) findViewById(R.id.baseUno);
        alturauno = (EditText) findViewById(R.id.altUno);
    }

    public void calcularAreas(View view){
        if (rectangulo.isChecked()){
            float sideOne = Float.parseFloat(ladoUno.getText().toString());
            float sideTwo = Float.parseFloat(ladoDos.getText().toString());
            resultado.setText(String.valueOf(sideOne*sideTwo));

        }
        if(triangulo.isChecked()){
            float sideOne = Float.parseFloat(baseuno.getText().toString());
            float sideTwo = Float.parseFloat(alturauno.getText().toString());
            resultado.setText(String.valueOf((sideOne*sideTwo)/2));
        }
    }
}