package com.savio.rentaroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.savio.rentaroom.command.Comando;

public class RegistarDepartamento extends AppCompatActivity {

    private EditText nome, centro, email, telefone;
    private Button button;

    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_departamento);

        nome = (EditText)findViewById(R.id.nomeDepartamentoEditID);
        centro =  (EditText)findViewById(R.id.centroPertencenteEditID);
        telefone = (EditText)findViewById(R.id.telefoneDepartamentoEditID);
        email = (EditText)findViewById(R.id.emailDepartamentoEditID);

        button = (Button)findViewById(R.id.registrarDID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c.addDepartamento(getApplicationContext(),
                        nome.getText().toString(),
                        telefone.getText().toString(),
                        email.getText().toString(),
                        centro.getText().toString());
                finish();
            }
        });
    }
}
