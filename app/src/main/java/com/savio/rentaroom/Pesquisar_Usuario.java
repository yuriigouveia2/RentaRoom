package com.savio.rentaroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class Pesquisar_Usuario extends Activity {

    private EditText texto;
    private Button botao;
    private Sala sala;
    private TextView lbl;
    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pesquisar__usuario);
        texto = (EditText) findViewById(R.id.pesquisarTextID);
        botao = (Button) findViewById(R.id.pesquisarButtonID);
    }


    public void btPesquisar(View v) {
        //Toast.makeText(getApplicationContext(), "Apertei o botao", Toast.LENGTH_SHORT).show();
        sala = c.getSala(texto.getText().toString());
        if (sala == null)
            Toast.makeText(getApplicationContext(), "Sala nao encontrada!", Toast.LENGTH_SHORT).show();

        else {
            lbl = (TextView) findViewById(R.id.label_a1);
            lbl.setText(sala.getNome().toString());

            lbl = (TextView) findViewById(R.id.label_a2);
            lbl.setText(sala.getCapacidade().toString());

            lbl = (TextView) findViewById(R.id.label_a3);
            lbl.setText(sala.getLocalizacao().toString());

            lbl = (TextView) findViewById(R.id.label_a4);
            lbl.setText(sala.getUso().toString());

            lbl = (TextView) findViewById(R.id.label_a5);
            lbl.setText(sala.getDepartamento_id().toString());

            lbl = (TextView) findViewById(R.id.label_a6);
            lbl.setText("");

            lbl = (TextView) findViewById(R.id.label1);
            lbl.setText("Nome: ");

            lbl = (TextView) findViewById(R.id.label2);
            lbl.setText("Capacidade: ");

            lbl = (TextView) findViewById(R.id.label3);
            lbl.setText("Localizacao: ");

            lbl = (TextView) findViewById(R.id.label4);
            lbl.setText("Uso: ");

            lbl = (TextView) findViewById(R.id.label5);
            lbl.setText("departamento: ");

            lbl = (TextView) findViewById(R.id.label6);
            lbl.setText("");
        }

    }
}
