package com.savio.rentaroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.savio.rentaroom.command.Comando;

public class RegistarCentro extends AppCompatActivity {

    private EditText nome, localizacao, telefone;
    private Button button;

    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_centro);

        nome = (EditText)findViewById(R.id.nomeCentroEditID);
        localizacao =  (EditText)findViewById(R.id.localidadeCentroEditID);
        telefone = (EditText)findViewById(R.id.telefoneCentroEditID);

        button = (Button)findViewById(R.id.registrarCentroBID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c.addCentro(getApplicationContext(), nome.getText().toString(),telefone.getText().toString(),
                        localizacao.getText().toString());

                finish();
            }
        });
    }
}
