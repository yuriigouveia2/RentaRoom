package com.savio.rentaroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class EditGerenteUsuario extends Activity {

    Comando comando = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gerente_usuario);

        final EditText mEditarNomeUsuarioID = (EditText) findViewById(R.id.editarNomeUsuarioID);
        final EditText mEditarCpfUsuarioID = (EditText) findViewById(R.id.editarCpfUsuarioID);
        final EditText mEditarEmailUsuarioID = (EditText) findViewById(R.id.editarEmailUsuarioID);
        final EditText mEditarTelefoneUsuarioID = (EditText) findViewById(R.id.editarTelefoneUsuarioID);
        final EditText mEditarDepartamentoUsuarioID = (EditText) findViewById(R.id.editarDepartamentoUsuarioID);
        final EditText mEditarLoginUsuarioID = (EditText) findViewById(R.id.editarLoginUsuarioID);
        final EditText mEditarSenharUsuarioID = (EditText) findViewById(R.id.editarSenharUsuarioID);

        Button mFinalizarUID = (Button) findViewById(R.id.finalizarUID);

        final Aluno aluno;
        final Funcionario funcionario;
        final Professor professor;

        Intent intent = getIntent();

        if (intent != null){
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                final String editarTextID = bundle.getString("ID");

                aluno = comando.getAluno(editarTextID);//pega aluno
                funcionario = comando.getFuncionario(editarTextID);//pega funcionario
                professor = comando.getProfessor(editarTextID);//pega professor

                final String usuarioID;
                final String tipoUsuario;

                if(aluno != null){
                    usuarioID = aluno.getMatricula();
                    mEditarNomeUsuarioID.setText(aluno.getNome());
                    mEditarCpfUsuarioID.setText(aluno.getCpf());
                    mEditarEmailUsuarioID.setText(aluno.getEmail());
                    mEditarTelefoneUsuarioID.setText(aluno.getTelefone());
                    mEditarDepartamentoUsuarioID.setText("null");
                    mEditarLoginUsuarioID.setText(aluno.getLogin());
                    mEditarSenharUsuarioID.setText(aluno.getSenha());
                    tipoUsuario = "aluno";
                }
                else if(funcionario != null){
                    usuarioID = funcionario.getCodigo();
                    mEditarNomeUsuarioID.setText(funcionario.getNome());
                    mEditarCpfUsuarioID.setText(funcionario.getCpf());
                    mEditarEmailUsuarioID.setText(funcionario.getEmail());
                    mEditarTelefoneUsuarioID.setText(funcionario.getTelefone());
                    mEditarDepartamentoUsuarioID.setText("null");
                    mEditarLoginUsuarioID.setText(funcionario.getLogin());
                    mEditarSenharUsuarioID.setText(funcionario.getSenha());
                    tipoUsuario = "funcionario";
                }
                else{
                    usuarioID = professor.getCodigo();
                    mEditarNomeUsuarioID.setText(professor.getNome());
                    mEditarCpfUsuarioID.setText(professor.getCpf());
                    mEditarEmailUsuarioID.setText(professor.getEmail());
                    mEditarTelefoneUsuarioID.setText(professor.getTelefone());
                    mEditarDepartamentoUsuarioID.setText(professor.getDepartamento_id());
                    mEditarLoginUsuarioID.setText(professor.getLogin());
                    mEditarSenharUsuarioID.setText(professor.getSenha());
                    tipoUsuario = "professor";
                }

                mFinalizarUID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(aluno != null) {
                            comando.apagarAluno(aluno.getMatricula());
                        }
                        else if(funcionario != null) {
                            comando.apagarFuncionario(funcionario.getCodigo());
                        }
                        else if(professor != null) {
                            comando.apagarProfessor(professor.getCodigo());
                        }

                        comando.addUsuario(usuarioID, mEditarNomeUsuarioID.getText().toString(), mEditarTelefoneUsuarioID.getText().toString(),mEditarCpfUsuarioID.getText().toString(), mEditarLoginUsuarioID.getText().toString(), mEditarSenharUsuarioID.getText().toString(), mEditarEmailUsuarioID.getText().toString(), tipoUsuario, mEditarDepartamentoUsuarioID.getText().toString());
                        finish();
                    }
                });
            }
        }

    }
}
