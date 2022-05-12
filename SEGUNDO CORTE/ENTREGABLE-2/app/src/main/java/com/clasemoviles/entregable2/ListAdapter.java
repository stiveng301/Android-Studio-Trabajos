package com.clasemoviles.entregable2;

import android.content.Context;
import android.widget.ImageView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;



public class ListAdapter extends BaseAdapter {
    Context contexto;
    String [] nombres, asunto, horaUltimoMensaje, mensaje;
    int[] idIconos;
    LayoutInflater inflater;

    public ListAdapter(Context contexto, String[] nombres, String[] mensaje, String[] asunto, String[] horaUltimoMensaje,
           int[] idIconos)
    {
        this.contexto = contexto;
        this.nombres = nombres;
        this.horaUltimoMensaje = horaUltimoMensaje;
        this.idIconos = idIconos;
        this.mensaje = mensaje;
        this.asunto = asunto;
        inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount()
    {
        return nombres.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

            view = inflater.inflate(R.layout.list_item, null);

            ImageView fotoPerfil = view.findViewById(R.id.iconoPerfil);
            TextView nombreUsuario = view.findViewById(R.id.nombreContacto);
            TextView ultimoMensaje = view.findViewById(R.id.ultimoMensaje);
            TextView horaMensaje = view.findViewById(R.id.horaMensaje);
            TextView cuerpoMensaje = view.findViewById(R.id.mensaje);
            fotoPerfil.setImageResource(idIconos[i]);
            nombreUsuario.setText(nombres[i]);
            ultimoMensaje.setText(asunto[i]);
            horaMensaje.setText(horaUltimoMensaje[i]);
            cuerpoMensaje.setText(mensaje[i]);

            return view;
    }
}
