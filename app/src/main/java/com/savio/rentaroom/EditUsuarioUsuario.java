package com.savio.rentaroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.command.Comando;

public class EditUsuarioUsuario extends AppCompatActivity {

    Comando comando;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usuario_usuario);

        comando = Comando.getInstancia();

        final EditText mEditarNomeUsuarioID = (EditText) findViewById(R.id.editarNomeUsuarioID_user);
        final EditText mEditarCpfUsuarioID = (EditText) findViewById(R.id.editarCpfUsuarioID_user);
        final EditText mEditarEmailUsuarioID = (EditText) findViewById(R.id.editarEmailUsuarioID_user);
        final EditText mEditarTelefoneUsuarioID = (EditText) findViewById(R.id.editarTelefoneUsuarioID_user);
        final EditText mEditarDepartamentoUsuarioID = (EditText) findViewById(R.id.editarDepartamentoUsuarioID_user);
        final EditText mEditarLoginUsuarioID = (EditText) findViewById(R.id.editarLoginUsuarioID_user);
        final EditText mEditarSenharUsuarioID = (EditText) findViewById(R.id.editarSenhaUsuarioID_user);
        final Button botaoEditarUsuario = (Button) findViewById(R.id.finalizarUID_user);

        final Aluno aluno_user;
        final Funcionario funcionario_user;
        final Professor professor_user;

        Intent intent = getIntent();


        //final String codigo = bundle.getString("ID");


        aluno_user = comando.getAluno(comando.getCodigo());//pega aluno_user
        funcionario_user = comando.getFuncionario(comando.getCodigo());//pega funcionario_user
        professor_user = comando.getProfessor(comando.getCodigo());//pega professor_user

        final String usuarioID;
        final String tipoUsuario;

        if (aluno_user != null) {
            usuarioID = aluno_user.getMatricula();
            mEditarNomeUsuarioID.setText(aluno_user.getNome());
            mEditarCpfUsuarioID.setText(aluno_user.getCpf());
            mEditarEmailUsuarioID.setText(aluno_user.getEmail());
            mEditarTelefoneUsuarioID.setText(aluno_user.getTelefone());
            mEditarDepartamentoUsuarioID.setText("null");
            mEditarLoginUsuarioID.setText(aluno_user.getLogin());
            mEditarSenharUsuarioID.setText(aluno_user.getSenha());
            tipoUsuario = "aluno";
        } else if (funcionario_user != null) {
            usuarioID = funcionario_user.getCodigo();
            mEditarNomeUsuarioID.setText(funcionario_user.getNome());
            mEditarCpfUsuarioID.setText(funcionario_user.getCpf());
            mEditarEmailUsuarioID.setText(funcionario_user.getEmail());
            mEditarTelefoneUsuarioID.setText(funcionario_user.getTelefone());
            mEditarDepartamentoUsuarioID.setText("null");
            mEditarLoginUsuarioID.setText(funcionario_user.getLogin());
            mEditarSenharUsuarioID.setText(funcionario_user.getSenha());
            tipoUsuario = "funcionario";
        } else {
            usuarioID = professor_user.getCodigo();
            mEditarNomeUsuarioID.setText(professor_user.getNome());
            mEditarCpfUsuarioID.setText(professor_user.getCpf());
            mEditarEmailUsuarioID.setText(professor_user.getEmail());
            mEditarTelefoneUsuarioID.setText(professor_user.getTelefone());
            mEditarDepartamentoUsuarioID.setText(professor_user.getDepartamento_id());
            mEditarLoginUsuarioID.setText(professor_user.getLogin());
            mEditarSenharUsuarioID.setText(professor_user.getSenha());
            tipoUsuario = "professor";
        }

        botaoEditarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aluno_user != null) {
                    comando.apagarAluno(aluno_user.getMatricula());
                } else if (funcionario_user != null) {
                    comando.apagarFuncionario(funcionario_user.getCodigo());
                } else {
                    comando.apagarProfessor(professor_user.getCodigo());
                }
                comando.addUsuario(usuarioID, mEditarNomeUsuarioID.getText().toString(), mEditarTelefoneUsuarioID.getText().toString(), mEditarCpfUsuarioID.getText().toString(), mEditarLoginUsuarioID.getText().toString(), mEditarSenharUsuarioID.getText().toString(), mEditarEmailUsuarioID.getText().toString(), tipoUsuario, mEditarDepartamentoUsuarioID.getText().toString());
                finish();
            }
        });
    }

}
