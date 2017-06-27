package com.savio.rentaroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.banco.Centro;
import com.savio.rentaroom.banco.Departamento;
import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TelaGerente extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView bemvindo;

    private ListView listView;

    private List<String> nomes;
    private ArrayAdapter<String> arrayAdapter;

    Comando c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gerente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_gerente);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_gerente);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_gerente);
        navigationView.setNavigationItemSelectedListener(this);

        c = Comando.getInstancia();

        bemvindo = (TextView)findViewById(R.id.texto_gerente);
        listView = (ListView)findViewById(R.id.lista_salas);

        Bundle nomeGerente = getIntent().getExtras();

        bemvindo.setText("Bem vindo, " + nomeGerente.getString("nome") + "!");

        listarSalas();

    }

    private void listarSalas() {

        List<Sala> salas  = c.getAllSalas();
        List<EstadoSala> estadoSalas = new ArrayList<EstadoSala>();

        Date horaAtual = Calendar.getInstance().getTime();

        String nome = "", estado = "";

        for(Sala s : salas){

            boolean livre = c.salaLivre(horaAtual,s.getAlugar_ids());

            nome = s.getNome();

            if (livre == true) estado = "Livre";
            else estado = "Ocupada";

            estadoSalas.add(new EstadoSala(nome, estado));
        }

        CustomListViewEstadoSala adapter = new CustomListViewEstadoSala(getApplicationContext(),
                R.layout.lista_estado_sala, estadoSalas);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_gerente);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_gerente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_gerente) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.aluga_sala_gerente) {

            startActivity(new Intent(TelaGerente.this, AlugarSalaActivity.class));

        } else if (id == R.id.pesquisar_gerente) {

            startActivity(new Intent(TelaGerente.this, Pesquisar.class));

        } else if (id == R.id.editar_gerente) {

            startActivity(new Intent(TelaGerente.this,EditGerente2.class));


        } else if (id == R.id.registrar) {

            startActivity(new Intent(TelaGerente.this, Registrar.class));
            listarSalas();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_gerente);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        listarSalas();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        listarSalas();
    }
}
