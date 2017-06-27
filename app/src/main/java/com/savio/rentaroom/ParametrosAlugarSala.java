package com.savio.rentaroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.command.Comando;

import java.util.Date;

public class ParametrosAlugarSala extends AppCompatActivity {

    private TextView diaInicial, mesInicial, anoInicial, horaInicial, minutoInicial;
    private TextView diaFinal, mesFinal, anoFinal, horaFinal, minutoFinal, capacidadeText;
    private RadioGroup groupUso;
    private RadioButton usoEscolhido;
    private Button alugar;
    private TextView titulo;

    private String nomeDaSala = new String();

    private int capacidade;

    Comando c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_alugar_sala);

        c = Comando.getInstancia();

        titulo = (TextView)findViewById(R.id.titulo_alugar_sala);

        diaInicial = (TextView)findViewById(R.id.diaInicialId);
        mesInicial = (TextView)findViewById(R.id.mesInicialId);
        anoInicial = (TextView)findViewById(R.id.anoInicialId);
        horaInicial = (TextView)findViewById(R.id.horaInicialId);
        minutoInicial = (TextView)findViewById(R.id.minutoInicialId);
        diaFinal = (TextView)findViewById(R.id.diaFinalId);
        mesFinal = (TextView)findViewById(R.id.mesFinalId);
        anoFinal = (TextView)findViewById(R.id.anoFinalId);
        horaFinal = (TextView)findViewById(R.id.horaFinalId);
        minutoFinal = (TextView)findViewById(R.id.minutoFinalId);
        capacidadeText = (TextView)findViewById(R.id.quantidade_paramentro);

        //groupUso = (RadioGroup)findViewById(R.id.radioGroupId);

        alugar = (Button)findViewById(R.id.alugarId);

        final Bundle nomeSala = getIntent().getExtras();
        nomeDaSala = nomeSala.getString("nome da sala");
        titulo.setText("Parametros para alugar a sala: " + nomeSala.getString("nome da sala"));

        alugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(capacidadeText.getText().toString().equals("")){
                    capacidade = 0;
                }else {
                    capacidade = Integer.parseInt(capacidadeText.getText().toString());
                }

                boolean menorOuIgual = capacidade <= c.getSala(nomeDaSala).getCapacidade();

                if (!verificar() && menorOuIgual) {

                        /*!verificar() &&*/

                    Toast.makeText(getApplicationContext(),"****",Toast.LENGTH_SHORT).show();


                        Date diaIni = new Date(Integer.parseInt(anoInicial.getText().toString()),
                                Integer.parseInt(mesInicial.getText().toString())-1,
                                Integer.parseInt(diaInicial.getText().toString()));

                        Date diaFin = new Date(Integer.parseInt(anoFinal.getText().toString()),
                                Integer.parseInt(mesFinal.getText().toString())-1,
                                Integer.parseInt(diaFinal.getText().toString()));

                        Date horaIni = new Date();
                        horaIni.setHours(Integer.parseInt(horaInicial.getText().toString())-1);
                        horaIni.setMinutes(Integer.parseInt(minutoInicial.getText().toString()));

                        Date horaFin = new Date();
                        horaFin.setHours(Integer.parseInt(horaFinal.getText().toString())-1);
                        horaFin.setMinutes(Integer.parseInt(minutoFinal.getText().toString()));

                        //alugo a sala
                        boolean resposta = c.alugarSala(nomeDaSala,diaIni,diaFin,horaIni,horaFin,capacidade);

                        if(resposta){
                            Toast.makeText(getApplicationContext(), "Sala alugada com Sucesso",Toast.LENGTH_SHORT).show();
                            finish();
                        }else{

                            Toast.makeText(getApplicationContext(), "Horario desejado, está ocupado",Toast.LENGTH_SHORT).show();

                        }



                }else{

                    Toast.makeText(getApplicationContext(),"Dados incorretos!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private boolean verificar(){

        int di,df,mi,mf,ai,af,hi,mti,hf,mtf;

        boolean erro = false;

        di = Integer.parseInt(diaInicial.getText().toString());
        df = Integer.parseInt(diaFinal.getText().toString());
        mi = Integer.parseInt(mesInicial.getText().toString());
        mf = Integer.parseInt(mesFinal.getText().toString());
        ai = Integer.parseInt(anoInicial.getText().toString());
        af = Integer.parseInt(anoFinal.getText().toString());
        hi = Integer.parseInt(horaInicial.getText().toString());
        mti = Integer.parseInt(minutoInicial.getText().toString());
        hf = Integer.parseInt(horaFinal.getText().toString());
        mtf = Integer.parseInt(minutoFinal.getText().toString());

        if(di > 30){

            Toast.makeText(this,"O dado do dia Inicial esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(mi > 12){

            Toast.makeText(this,"O dado do mes Inicial esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(ai < 2016){

            Toast.makeText(this,"O dado do ano Inicial esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(df > 30){

            Toast.makeText(this,"O dado do dia final esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(mf > 12){

            Toast.makeText(this,"O dado do mes final esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(af < 2016){

            Toast.makeText(this,"O dado do ano final esta incorreto!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if(af < ai){
            Toast.makeText(this,"O ano final está menor que o inicial!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((af == ai)&&(mf < mi)){
            Toast.makeText(this,"O mês final está menor que o inicial!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((mf == mi)&&(df < di)){
            Toast.makeText(this,"O dia final está menor que o inicial!", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((hi > 23)||(hf > 23)){
            Toast.makeText(this,"A hora está incorreta", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((di == df)&&(hf < hi)){
            Toast.makeText(this,"A hora Final está menor que a inicial", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((mti > 59)||(mtf > 59)){

            Toast.makeText(this,"Os minutos estao incorretos", Toast.LENGTH_SHORT).show();
            erro = true;
        }else if((hi == hf)&&(mtf < mti)){
            Toast.makeText(this,"O minuto final está menor que o inicial!", Toast.LENGTH_SHORT).show();
            erro = true;
        }

        return erro;
    }
}
