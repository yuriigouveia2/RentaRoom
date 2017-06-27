package com.savio.rentaroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.command.Comando;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AlugarSalaActivity extends AppCompatActivity {

    private ListView listasSalasLivres;

    private List<String> nomes;
    private ArrayAdapter<String> arrayAdapter;
    private List<AlugaSala> alugaSalas;
    Comando c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alugar_sala);

        c = Comando.getInstancia();

        //procurar salas livres

        listasSalasLivres = (ListView)findViewById(R.id.ListaSalasLivresIds);

        //setar nas listas

        listasSalasLivres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ir para a activi alugar sala livel 2
                Intent intent = new Intent(AlugarSalaActivity.this,ParametrosAlugarSala.class);
                //intent.putExtra("nome","gerente");
                intent.putExtra("nome da sala",alugaSalas.get(position).getNomeSala()); //pegar o primeiro valor do lista
                startActivity(intent);
                finish();
                //Log.i("AlugarSala", alugaSalas.get(position).getNomeSala());
            }
        });

        //c.colocarSalasNaLista(getApplicationContext(),listasSalasLivres);
        listarSalas();
    }

    private void listarSalas() {

        List<Sala> salas  = c.getAllSalas();
        alugaSalas = new ArrayList<AlugaSala>();

        String nome = "", uso = "";
        int capacidade;

        for(Sala s : salas){

            nome = s.getNome();
            uso = s.getUso();
            capacidade = s.getCapacidade();

            alugaSalas.add(new AlugaSala(nome, uso, String.valueOf(capacidade)));
        }

        CustomListViewAlugaSala adapter = new CustomListViewAlugaSala(getApplicationContext(),
                R.layout.aluga_sala, alugaSalas);

        listasSalasLivres.setAdapter(adapter);
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
