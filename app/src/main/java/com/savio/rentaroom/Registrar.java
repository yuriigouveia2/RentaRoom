package com.savio.rentaroom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.savio.rentaroom.command.Comando;

public class Registrar extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button button;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupRegistrarID);
        button = (Button)findViewById(R.id.okRegistrarID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());



                    if (radioButton == (RadioButton) findViewById(R.id.regCentroID)) {
                        startActivity(new Intent(Registrar.this, RegistarCentro.class));
                        finish();
                    } else if (radioButton == (RadioButton) findViewById(R.id.regDepartamentoID)) {
                        startActivity(new Intent(Registrar.this, RegistarDepartamento.class));
                        finish();
                    } else if(radioButton == (RadioButton)findViewById(R.id.regSalaID)){
                        startActivity(new Intent(Registrar.this, RegistarSala.class));
                        finish();
                    }


            }
        });
    }


}