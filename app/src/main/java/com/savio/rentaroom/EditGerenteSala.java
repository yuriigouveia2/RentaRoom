package com.savio.rentaroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

public class EditGerenteSala extends AppCompatActivity {

    Comando comando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gerente_sala);

        final EditText mEditarCapacidadeSalaID = (EditText) findViewById(R.id.editarCapacidadeSalaID);
        final EditText mEditarLocalizacaoSalaID = (EditText) findViewById(R.id.editarLocalizacaoSalaID);
        final EditText mEditarUsoSalaID = (EditText) findViewById(R.id.editarUsoSalaID);
        final EditText mEditarDepartamentoSalaID = (EditText) findViewById(R.id.editarDepartamentoSalaID);
        TextView mNomeSalaID = (TextView) findViewById(R.id.nomeSalaID);
        Button botaoApagarSalaID = (Button) findViewById(R.id.apagarSalaID);
        Button botaoEditarSalaID = (Button) findViewById(R.id.editarSalaID);

        comando = Comando.getInstancia();
        final Sala sala;

        Intent intent = getIntent();

        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                final String editarTextID = bundle.getString("ID");

                mNomeSalaID.setText(editarTextID);

                sala = comando.getSala(editarTextID);//pega sala


                mEditarCapacidadeSalaID.setText(sala.getCapacidade().toString());
                mEditarLocalizacaoSalaID.setText(sala.getLocalizacao());
                mEditarUsoSalaID.setText(sala.getUso());
                mEditarDepartamentoSalaID.setText(sala.getDepartamento_id());

                botaoApagarSalaID.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View v) {
                        comando.apagarSala(sala.getNome());//apaga sala
                        Toast.makeText(getApplicationContext(), "Sala apagada", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });

                botaoEditarSalaID.setOnClickListener(new View.OnClickListener() {//DANDO ERRO
                    @Override
                    public void onClick(View view) {
                        String nomeSala = sala.getNome();
                        comando.apagarSala(sala.getNome());
                        comando.addSala(getApplicationContext(), mEditarUsoSalaID.getText().toString(), mEditarLocalizacaoSalaID.getText().toString(), Integer.parseInt(mEditarCapacidadeSalaID.getText().toString()), nomeSala, mEditarDepartamentoSalaID.getText().toString());
                        finish();
                    }
                });
            }
        }
    }
    protected void onStop(){
        setResult(0);
        super.onStop();
    }
}