package com.example.entrega_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private EditText cedula, nombre, saldo, debitar;
    TextView resultado;
    float saldoini, saldodebitado, resta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cedula = (EditText) findViewById(R.id.etcedula);
        nombre = (EditText) findViewById(R.id.etnombre);
        saldo = (EditText) findViewById(R.id.etsaldo);
        debitar = (EditText) findViewById(R.id.etdebisaldo);
        resultado = (TextView) findViewById(R.id.resultado);

    }

    public void registrar(View view) {

        AdminBD admin = new AdminBD(this, "basedatos", null, 1);
        //Abrir la base de datos (instanciar la base de datos)
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String Rcedula = cedula.getText().toString();
        String Rnombre = nombre.getText().toString();
        String Rsaldo = saldo.getText().toString();

        //PROFE, SI SE APLICA ESTE CODIGO PARA HACER LA VALIDACIÓN SI YA EXISTE EL USUARIO, NO DEJA REGISTRAR, ESO LE PASÓ A SU APP EL DÍA QUE ME LA MOSTRÓ COMO EJEMPLO, NO LE DEJÓ REGISTRAR MÁS USUARIOS
       /*if (!Rcedula.isEmpty()){
            Cursor fila  = BaseDatos.rawQuery("select cedula, nombre, saldo from usuario where cedula ="+Rcedula,null);
            if (fila.moveToFirst()){
                String idPersona = fila.getString(0);
                if (!idPersona.isEmpty()){
                    Toast.makeText(this, "El registro ya existe", Toast.LENGTH_SHORT).show();
                }
            }
        }*/

        if (!Rcedula.isEmpty() && !Rnombre.isEmpty() && !Rsaldo.isEmpty()) {

            ContentValues registro = new ContentValues();
            //Almacenar datos
            registro.put("cedula", Rcedula);
            registro.put("nombre", Rnombre);
            registro.put("saldo", Rsaldo);
            //Insertar la información en la tabla
            BaseDatos.insert("usuario", null, registro);
            //Cerrar Base de datos
            BaseDatos.close();
            //Limpiar campos
            cedula.setText("");
            nombre.setText("");
            saldo.setText("");

            Toast.makeText(this, "Registro almacenado correctamente", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Ingrese correctamente todos los datos", Toast.LENGTH_LONG).show();

        }

    }

    public void consultar(View view) {

        AdminBD admin = new AdminBD(this, "basedatos", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();
        String cedula1 = cedula.getText().toString();

        if (!cedula1.isEmpty()) {

            Cursor fila = BasedeDatos.rawQuery("select nombre, saldo from usuario where cedula=" + cedula1, null);

            if (fila.moveToFirst()) {
                nombre.setText(fila.getString(0));
                saldo.setText(fila.getString(1));
                BasedeDatos.close();
                Toast.makeText(this, "Datos consultados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se encontró el usuario", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingrese un documento de consulta", Toast.LENGTH_SHORT).show();
        }

    }

    public void Retirar(View view) {


        String saldoS = saldo.getText().toString();
        String saldodebitadoS = debitar.getText().toString();

        saldoini = Float.parseFloat(saldoS);
        saldodebitado = Float.parseFloat(saldodebitadoS);


        if (!saldoS.isEmpty()) {

            if (saldoini > saldodebitado) {

                resta = (saldoini - saldodebitado);
                Log.i("resta",String.valueOf(resta));

                resultado.setText(String.valueOf(resta));
                Toast.makeText(this, "Saldo debitado correctamente)", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se puede hacer el retiro (Valor mayor al permitido)", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "Por favor ingrese un valor a debitar", Toast.LENGTH_SHORT).show();
        }

    }
}