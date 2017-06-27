package com.savio.rentaroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class EditUsuario extends Activity {

    private EditText mEditText_user;
    private Button mButton_user;
    private Aluno aluno_user;
    private Funcionario funcionario_user;
    private Professor professor_user;

    Comando comando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usuario);

        mEditText_user = (EditText) findViewById(R.id.busca_texto_editar_user);
        mButton_user = (Button) findViewById(R.id.botao_editar_editar_user);

        comando = Comando.getInstancia();

        final Bundle bundle = new Bundle();

        mButton_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno_user = comando.getAluno(mEditText_user.getText().toString());
                funcionario_user = comando.getFuncionario(mEditText_user.getText().toString());
                professor_user = comando.getProfessor(mEditText_user.getText().toString());

                if(aluno_user != null){
                    chamaIntent(new Intent(EditUsuario.this, EditUsuarioUsuario.class), bundle);
                }
                else if(funcionario_user != null){
                    chamaIntent(new Intent(EditUsuario.this, EditUsuarioUsuario.class), bundle);
                }
                else if(professor_user != null){
                    chamaIntent(new Intent(EditUsuario.this, EditUsuarioUsuario.class), bundle);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Usuário não encontrado", Toast.LENGTH_SHORT).show();
                }
            }
            public void chamaIntent(Intent i, Bundle b){
                b.putString("ID", mEditText_user.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
    }
}
