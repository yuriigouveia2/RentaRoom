package com.savio.rentaroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class Pesquisar extends Activity {

    private EditText texto;
    private Button botao;
    private RadioButton radioB;
    private RadioGroup radioG;
    private Sala sala;
    private Professor professor;
    private Aluno aluno;
    private Funcionario funcionario;
    private TextView lbl;
    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pesquisar);
        texto = (EditText) findViewById(R.id.pesquisarTextID);
        botao = (Button) findViewById(R.id.pesquisarButtonID);
        radioG = (RadioGroup) findViewById(R.id.radioGroupID);
    }


    public void btPesquisar(View v){
        //Toast.makeText(getApplicationContext(), "Apertei o botao", Toast.LENGTH_SHORT).show();
        radioB = (RadioButton) findViewById(radioG.getCheckedRadioButtonId());

        //se for sala
        if(radioB == (RadioButton) findViewById(R.id.salaID)) {
            sala = c.getSala(texto.getText().toString());
            if(sala == null)
                Toast.makeText(getApplicationContext(), "Sala nao encontrada!", Toast.LENGTH_SHORT).show();

            else{
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
        else if(radioB == (RadioButton) findViewById(R.id.usuarioID)) {
            aluno = c.getAluno(texto.getText().toString());
            professor = c.getProfessor(texto.getText().toString());
            funcionario = c.getFuncionario(texto.getText().toString());

            //Coloca os valores do usuario: matricula, nome, cpf, email, telefone, departamento
            if(aluno != null){
                lbl = (TextView) findViewById(R.id.label_a1);
                lbl.setText(aluno.getMatricula());

                lbl = (TextView) findViewById(R.id.label_a2);
                lbl.setText(aluno.getNome());

                lbl = (TextView) findViewById(R.id.label_a3);
                lbl.setText(aluno.getCpf());

                lbl = (TextView) findViewById(R.id.label_a4);
                lbl.setText(aluno.getEmail());

                lbl = (TextView) findViewById(R.id.label_a5);
                lbl.setText(aluno.getTelefone());

                lbl = (TextView) findViewById(R.id.label_a6);
                lbl.setText("");



            }

            else if (professor != null){
                lbl = (TextView) findViewById(R.id.label_a1);
                lbl.setText(professor.getCodigo().toString());

                lbl = (TextView) findViewById(R.id.label_a2);
                lbl.setText(professor.getNome().toString());

                lbl = (TextView) findViewById(R.id.label_a3);
                lbl.setText(professor.getCpf().toString());

                lbl = (TextView) findViewById(R.id.label_a4);
                lbl.setText(professor.getEmail().toString());

                lbl = (TextView) findViewById(R.id.label_a5);
                lbl.setText(professor.getTelefone().toString());

                lbl = (TextView) findViewById(R.id.label_a6);
                lbl.setText(professor.getDepartamento_id().toString());

                lbl = (TextView) findViewById(R.id.label6);
                lbl.setText("Departamento: ");

            }
            else if(funcionario != null){
                lbl = (TextView) findViewById(R.id.label_a1);
                lbl.setText(funcionario.getCodigo().toString());

                lbl = (TextView) findViewById(R.id.label_a2);
                lbl.setText(funcionario.getNome().toString());

                lbl = (TextView) findViewById(R.id.label_a3);
                lbl.setText(funcionario.getCpf().toString());

                lbl = (TextView) findViewById(R.id.label_a4);
                lbl.setText(funcionario.getEmail().toString());

                lbl = (TextView) findViewById(R.id.label_a5);
                lbl.setText(funcionario.getTelefone().toString());

                lbl = (TextView) findViewById(R.id.label_a6);
                lbl.setText("");

            }
            if(funcionario != null || aluno != null || professor != null) {
                //Coloca os labels do usuario: matricula, nome, cpf, email, telefone, departamento
                lbl = (TextView) findViewById(R.id.label1);
                lbl.setText("Matricula: ");

                lbl = (TextView) findViewById(R.id.label2);
                lbl.setText("Nome: ");

                lbl = (TextView) findViewById(R.id.label3);
                lbl.setText("CPF: ");

                lbl = (TextView) findViewById(R.id.label4);
                lbl.setText("Email: ");

                lbl = (TextView) findViewById(R.id.label5);
                lbl.setText("Telefone: ");

            }
            else
                Toast.makeText(getApplicationContext(), "Usuario nao encontrado!", Toast.LENGTH_SHORT).show();

        }

    }
}
