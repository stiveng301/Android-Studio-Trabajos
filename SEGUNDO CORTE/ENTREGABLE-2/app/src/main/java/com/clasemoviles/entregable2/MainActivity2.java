package com.clasemoviles.entregable2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity
{
    String mensaje, asunto, nombre;
    TextView asuntoVista;
    TextView nombreRemitente;
    TextView mensajeRemitente;
    TextView cuerpoMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);

      mensaje = getIntent().getStringExtra("mensaje");
      asunto = getIntent().getStringExtra("asunto");
      nombre = getIntent().getStringExtra("nombre");

      asuntoVista = findViewById(R.id.asunto);
      mensajeRemitente = findViewById(R.id.mensaje);
      nombreRemitente = findViewById(R.id.remitente);
      cuerpoMensaje = findViewById(R.id.cuerpoMensaje);

      asuntoVista.setText(asunto);
      nombreRemitente.setText("Remitente: " + nombre);
      cuerpoMensaje.setText(mensaje);
    }

}
