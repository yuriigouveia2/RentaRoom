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

public class CustomListViewAlugaSala extends ArrayAdapter<AlugaSala> {

    Context context;

    public CustomListViewAlugaSala(Context context, int resourceId, List<AlugaSala> items){

        super(context,resourceId,items);
        this.context = context;
    }

    private class ViewHolderAlugaSala{

        TextView nomeSala;
        TextView uso;
        TextView quantidade;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolderAlugaSala holder = null;
        AlugaSala alugaSala = getItem(position);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView== null){

            convertView = inflater.inflate(R.layout.aluga_sala, null);

            holder = new ViewHolderAlugaSala();
            holder.nomeSala = (TextView)convertView.findViewById(R.id.aluga_sala_nome_sala);
            holder.uso = (TextView)convertView.findViewById(R.id.aluga_sala_uso);
            holder.quantidade = (TextView)convertView.findViewById(R.id.aluga_sala_capacidade);
            convertView.setTag(holder);

        }else{

            holder = (ViewHolderAlugaSala)convertView.getTag();
        }

        holder.nomeSala.setText(alugaSala.getNomeSala());
        holder.uso.setText(alugaSala.getUso());
        holder.quantidade.setText(alugaSala.getQuantidade());

        return convertView;
    }
}
