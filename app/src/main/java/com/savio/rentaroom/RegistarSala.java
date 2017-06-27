package com.savio.rentaroom;

import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.savio.rentaroom.command.Comando;

public class RegistarSala extends AppCompatActivity {

    //nomeSalaId,capacidadeSalaId,localizacaoSalaId,usoSalaId,departamentoSalaID,registrarSalaId
    private EditText nomeSala, capacidadeSala, localizacaoSala,UsoSala,DepartamentoSala;
    private Button redistrarSala;

    Comando c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_sala);

        c = Comando.getInstancia();

        nomeSala = (EditText)findViewById(R.id.nomeSalaEditID);
        capacidadeSala = (EditText)findViewById(R.id.capacidadeSalaEditID);
        localizacaoSala = (EditText)findViewById(R.id.localizacaoSalaEditID);
        UsoSala = (EditText)findViewById(R.id.usoSalaEditID);
        DepartamentoSala = (EditText)findViewById(R.id.departamentoSalaEditID);
        redistrarSala = (Button)findViewById(R.id.registrarSID);

        redistrarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.addSala(getApplicationContext(),
                        UsoSala.getText().toString(),
                        localizacaoSala.getText().toString(),
                        Integer.parseInt(capacidadeSala.getText().toString()),
                        nomeSala.getText().toString(),
                        DepartamentoSala.getText().toString());

                finish();
            }
        });
    }
}
