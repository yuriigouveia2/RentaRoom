package com.savio.rentaroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TelaCliente extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Comando comando = Comando.getInstancia();
    private TextView bemvindo;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bemvindo = (TextView)findViewById(R.id.texto_cliente);
        listView = (ListView)findViewById(R.id.lista_sala_tela_cliente);

        Bundle nomeClient = getIntent().getExtras();

        bemvindo.setText("Bem vindo, " + nomeClient.getString("nome") + "!");

        listarSalas();
    }

    private void listarSalas() {

        List<Sala> salas  = comando.getAllSalas();
        List<EstadoSala> estadoSalas = new ArrayList<EstadoSala>();

        Date horaAtual = Calendar.getInstance().getTime();

        String nome = "", estado = "";

        for(Sala s : salas){

            boolean livre = comando.salaLivre(horaAtual,s.getAlugar_ids());

            nome = s.getNome();

            if (livre == true) estado = "Livre";
            else estado = "Ocupado";

            estadoSalas.add(new EstadoSala(nome, estado));
        }

        CustomListViewEstadoSala adapter = new CustomListViewEstadoSala(getApplicationContext(),
                R.layout.lista_estado_sala, estadoSalas);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Aluno aluno_user;
    Funcionario funcionario_user;
    Professor professor_user;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here
        int id = item.getItemId();

        if (id == R.id.aluga_sala) {
            startActivity(new Intent(TelaCliente.this, AlugarSalaActivity.class));

            // Handle the camera action
        } else if (id == R.id.pesquisar) {
            startActivity(new Intent(TelaCliente.this, Pesquisar_Usuario.class));

        } else if (id == R.id.editar) {
            aluno_user = comando.getAluno(comando.getCodigo());
            funcionario_user = comando.getFuncionario(comando.getCodigo());
            professor_user = comando.getProfessor(comando.getCodigo());

            if(aluno_user != null){
                startActivity(new Intent(TelaCliente.this, EditUsuarioUsuario.class));
            }
            else if(funcionario_user != null){
                startActivity(new Intent(TelaCliente.this, EditUsuarioUsuario.class));
            }
            else if(professor_user != null){
                startActivity(new Intent(TelaCliente.this, EditUsuarioUsuario.class));
            }
            else{
                Toast.makeText(getApplicationContext(), "Usuário não encontrado", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
