package com.clasemoviles.entregable2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idIconos = {
                R.mipmap.icono_01_round,
                R.mipmap.icono_02_round,
                R.mipmap.icono_03_round,
                R.mipmap.icono_04_round,
                R.mipmap.icono_05_round,
                R.mipmap.icono_06_round
        };

        String[] nombres = {
                "Andrea Ochoa",
                "Tienda Verde",
                "Banco ITAU",
                "DIAN",
                "La Tiquetera",
                "Solo Learn"
        };

        String[] asunto ={
                "Registro Exitoso",
                "Promociones",
                "Documentacion Recibida con Exito",
                "Declaración de Renta",
                "Compra Exitosa",
                "Aprobación Curso"
        };

        String[] mensaje ={
                "Su registro ha sido exitoso, le enviaremos un email para confirmar su cuenta",
                "Indumentaria del equipo con el 40% de descuento",
                "Tu tarjeta de crédito ha sido activada y puedes usarla a partir de este momento",
                "Tu Declaracion de Renta fue procesada con éxito",
                "Tu compra ha sido exitosa, el evento se realizará el día 30 de Mayo de 2022",
                "Has aprobado tu curso de HTML5, te invitamos a continuar con tu proceso de aprendizaje"
        };

        String[] horaUltimoMensaje ={
                "07:26", "16:12", "22:36" ,"17:11" ,"03:36" ,"20:58"
        };

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, nombres, mensaje, asunto, horaUltimoMensaje, idIconos);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                intent.putExtra("nombre", nombres[posicion]);
                intent.putExtra("asunto", asunto[posicion]);
                intent.putExtra("mensaje", mensaje[posicion]);
                startActivity(intent);

            }
        });

    }
}