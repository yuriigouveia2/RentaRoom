package com.savio.rentaroom;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.savio.rentaroom.command.Comando;

/**
 * Created by savio on 14/11/16.
 */

public class Registrar_usuario extends AppCompatActivity {

    private EditText name;
    private EditText cpf;
    private EditText email;
    private EditText fone;
    private EditText idM;
    private EditText departamento;
    private EditText login;
    private EditText senha;

    private Button button;

    private RadioGroup group;
    private RadioButton buttonRadio;

    Comando command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        command = Comando.getInstancia();

        button = (Button) findViewById(R.id.finalizarUID);

        name = (EditText) findViewById(R.id.nomeUsuarioEditID);
        cpf = (EditText) findViewById(R.id.cpfUsuarioEditID);
        email = (EditText) findViewById(R.id.emailUsuarioEditID);
        fone = (EditText) findViewById(R.id.telefoneUsuarioEditID);
        idM = (EditText) findViewById(R.id.idUsuarioEditID);
        departamento = (EditText) findViewById(R.id.departamentoUsuarioEditID);
        login = (EditText) findViewById(R.id.loginUsuarioEditID);
        senha = (EditText) findViewById(R.id.senhaUsuarioEditID);

        group = (RadioGroup) findViewById(R.id.radioGroupUsuarioID);



        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                if (verificarEntradas())
                {

                    String n = name.getText().toString();
                    String c = cpf.getText().toString();
                    String e = email.getText().toString();
                    String f = fone.getText().toString();
                    String i = idM.getText().toString();
                    String l = login.getText().toString();
                    String s = senha.getText().toString();
                    String d = departamento.getText().toString();

                    buttonRadio = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                    String func = buttonRadio.getText().toString();

                    boolean resultado = command.buscarNoSigaa(i,n,c);
                    //banco de dados vai aqui, todos os dados devem ser comparados para atestar a veracidade ou serem incluídos diretamente
                    if(resultado)
                    {
                        if(func.equals("Professor")) {

                            command.addUsuario(i, n, f, c, l, s, e, func,d);



                        }
                        else if(func.equals("Aluno")) {

                            command.addUsuario(i, n, f, c, l, s, e, func, null);

                        }
                        else {

                            command.addUsuario(i, n, f, c, l, s, e, func, null);

                        }

                        String info = "Cadastro feito com sucesso!";
                        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
                        finish();

                    }
                    else
                    {

                        String info = "Os dados informados não são autênticos, insira corretamente";
                        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
                        //finish();

                    }


                }
                else
                {
                    //Simplismente informativo, caso todos os campos não seja preenchido, só mostrar a informação na tela e continuar lá

                    String err = "Atenção, preencha todos os campos e corretamente";
                    Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();


                }


            }

        });

    }

    private boolean verificarEntradas() {

        if ((name.getText().toString().equals("")) || (cpf.getText().toString().equals("")) || (email.getText().toString().equals("")) || (fone.getText().toString().equals("")) ||
                (idM.getText().toString().equals("")) || (group.getCheckedRadioButtonId() < 0) || departamento.getText().toString().equals("") || login.getText().toString().equals("") ||
        senha.getText().toString().equals("")) {

            return false;

        } else {

            return true;

        }

    }

}
