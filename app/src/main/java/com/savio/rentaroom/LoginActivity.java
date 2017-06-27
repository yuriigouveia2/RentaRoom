package com.savio.rentaroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.savio.rentaroom.command.Comando;


public class LoginActivity extends AppCompatActivity {

    private EditText login, senha;
    private Button botao_logar, botao_registrar;

    Comando c = Comando.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        c.criarBanco(getApplicationContext());
        c.criarTables();
        c.addGerente("admin","admin");
        c.addUsuario("123456","savio","12345","103282","savinho","senha","savio@email","aluno",null);
        c.gerarSigaa();

        login = (EditText)findViewById(R.id.loginId);
        senha = (EditText)findViewById(R.id.SenhaId);
        botao_logar = (Button)findViewById(R.id.button);
        botao_registrar = (Button)findViewById(R.id.login_botao_registrar_id);

        botao_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this,Registrar_usuario.class));
            }
        });

        botao_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEntrada = login.getText().toString();
                String senhaEntrada = senha.getText().toString();

                int quemLogou = c.logar(loginEntrada,senhaEntrada);

                if(quemLogou == 1){

                    Intent intent = new Intent(LoginActivity.this, TelaGerente.class);
                    intent.putExtra("nome","gerente");
                    startActivity(intent);

                }else if(quemLogou == 2){

                    Intent intent = new Intent(LoginActivity.this, TelaCliente.class);
                    intent.putExtra("nome","usuario");
                    startActivity(intent);

                }else{

                    Toast.makeText(getApplicationContext(),"Voce não possue uma conta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
