package com.savio.rentaroom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by savio on 15/11/16.
 */

public class CustomListViewEstadoSala extends ArrayAdapter<EstadoSala> {

    Context context;

    public CustomListViewEstadoSala(Context context, int resourceId, List<EstadoSala> items){

        super(context,resourceId,items);
        this.context = context;
    }

    private class ViewHolderEstadoSala{

        TextView nomeSala;
        TextView estadoSala;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolderEstadoSala holder = null;
        EstadoSala estadoSala = getItem(position);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView== null){

            convertView = inflater.inflate(R.layout.lista_estado_sala, null);

            holder = new ViewHolderEstadoSala();
            holder.nomeSala = (TextView)convertView.findViewById(R.id.estado_sala_nome_sala);
            holder.estadoSala = (TextView)convertView.findViewById(R.id.estado_sala_estado);
            convertView.setTag(holder);

        }else{

            holder = (ViewHolderEstadoSala)convertView.getTag();
        }

        holder.nomeSala.setText(estadoSala.getNomeSala());
        holder.estadoSala.setText(estadoSala.getEstadoSala());

        return convertView;
    }
}
