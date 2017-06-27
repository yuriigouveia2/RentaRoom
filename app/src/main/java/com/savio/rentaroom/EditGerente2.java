package com.savio.rentaroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class EditGerente2 extends Activity {
    private RadioGroup radioGroup_editar;
    private RadioButton radioButtonUsuario_editar;
    private RadioButton radioButtonSala_editar;
    private RadioButton radioButton_editar;
    private EditText editTextID_editar;
    private Button botao_editar;
    private Sala sala;
    private Aluno aluno;
    private Funcionario funcionario;
    private Professor professor;

    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gerente2);

        final Intent intent = new Intent(EditGerente2.this, EditGerenteUsuario.class);
        final Intent intent2 = new Intent(EditGerente2.this, EditGerenteSala.class);
        final Bundle bundle = new Bundle();

        radioGroup_editar = (RadioGroup) findViewById(R.id.group_botao_editar);
        radioButtonUsuario_editar = (RadioButton) findViewById(R.id.botao_usuario_editar);
        radioButtonSala_editar = (RadioButton) findViewById(R.id.botao_sala_editar);
        editTextID_editar = (EditText) findViewById(R.id.busca_texto_editar);
        botao_editar = (Button) findViewById(R.id.botao_editar_editar);

        botao_editar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                radioButton_editar = (RadioButton) findViewById(radioGroup_editar.getCheckedRadioButtonId());

                if(radioButton_editar == radioButtonUsuario_editar){
                    aluno = c.getAluno(editTextID_editar.getText().toString());
                    funcionario = c.getFuncionario(editTextID_editar.getText().toString());
                    professor = c.getProfessor(editTextID_editar.getText().toString());

                    if(aluno != null){
                        chamaIntent(intent, bundle);
                    }
                    else if(funcionario != null){
                        chamaIntent(intent, bundle);
                    }
                    else if(professor != null){
                        chamaIntent(intent, bundle);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Usuário não encontrado", Toast.LENGTH_SHORT).show();
                    }
                }
                if(radioButton_editar == radioButtonSala_editar){
                    sala = c.getSala(editTextID_editar.getText().toString());

                    if(sala != null){
                        chamaIntent(intent2, bundle);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sala não encontrada", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            public void chamaIntent(Intent i, Bundle b){
                b.putString("ID", editTextID_editar.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
    }
}
