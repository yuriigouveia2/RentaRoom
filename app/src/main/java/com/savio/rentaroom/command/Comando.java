package com.savio.rentaroom.command;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.savio.rentaroom.R;
import com.savio.rentaroom.banco.Aluga;
import com.savio.rentaroom.banco.AlugaDao;
import com.savio.rentaroom.banco.Aluno;
import com.savio.rentaroom.banco.AlunoDao;
import com.savio.rentaroom.banco.AlunoSigaa;
import com.savio.rentaroom.banco.AlunoSigaaDao;
import com.savio.rentaroom.banco.Centro;
import com.savio.rentaroom.banco.CentroDao;
import com.savio.rentaroom.banco.DaoMaster;
import com.savio.rentaroom.banco.DaoSession;
import com.savio.rentaroom.banco.Departamento;
import com.savio.rentaroom.banco.DepartamentoDao;
import com.savio.rentaroom.banco.Funcionario;
import com.savio.rentaroom.banco.FuncionarioDao;
import com.savio.rentaroom.banco.FuncionarioSigaa;
import com.savio.rentaroom.banco.FuncionarioSigaaDao;
import com.savio.rentaroom.banco.Gerente;
import com.savio.rentaroom.banco.GerenteDao;
import com.savio.rentaroom.banco.Professor;
import com.savio.rentaroom.banco.ProfessorDao;
import com.savio.rentaroom.banco.ProfessorSigaa;
import com.savio.rentaroom.banco.ProfessorSigaaDao;
import com.savio.rentaroom.banco.Sala;
import com.savio.rentaroom.banco.SalaDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by savio on 04/11/2016.
 */

public class Comando {

    private static Comando instancia;

    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase database;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private AlunoDao alunoDao;
    private CentroDao centroDao;
    private DepartamentoDao departamentoDao;
    private FuncionarioDao funcionarioDao;
    private GerenteDao gerenteDao;
    private ProfessorDao professorDao;
    private SalaDao salaDao;
    private AlugaDao alugaDao;
    private AlunoSigaaDao alunoSigaaDao;
    private FuncionarioSigaaDao funcionarioSigaaDao;
    private ProfessorSigaaDao professorSigaaDao;

    private String codigo = new String();
    private String tipo = new String();

    public List<String> nomes;
    public ArrayAdapter<String> arrayAdapter;

    public boolean salaLivre(Date horaAtual, List<Aluga> horariosSalvos){

        if(horariosSalvos.size() <= 0) {
            Log.i("salaLivre", "retornou zero");
            return true;
        }

        else{

            try {
                Date dataInicial = new Date(horaAtual.getYear()+1900, horaAtual.getMonth(), horaAtual.getDate());
                Date hora = new Date();
                hora.setHours(horaAtual.getHours());
                hora.setMinutes(horaAtual.getSeconds());

                List<Date> horaIniciais = new ArrayList<Date>(), horaFinais = new ArrayList<Date>();
                int b = 0;

                Log.i("salaLivre", "ano: " + dataInicial.getYear() + " mes: " + dataInicial.getMonth() + " dia: " + dataInicial.getDate());

                for (Aluga a : horariosSalvos) {

                    Log.i("salaLivre", "" + b++);
                    Log.i("salaLivre", "ano_i: " + a.getDia_inicial().getYear() +
                    " mes_i: " + a.getDia_inicial().getMonth() + " dia_i: " + a.getDia_inicial().getDate());


                    if ((dataInicial.after(a.getDia_inicial()) || dataInicial.equals(a.getDia_inicial())) &&
                            (dataInicial.before(a.getDia_termino()) || dataInicial.equals(a.getDia_termino()))) {

                        horaIniciais.add(a.getHora_inicial());
                        horaFinais.add(a.getHora_termino());
                    }
                }

                if (horaIniciais.size() <= 0) {
                    return true;
                }

                int tamanho = horaIniciais.size();
                int resultado = tamanho;

                for (int i = 0; i < tamanho; i++) {

                    int h = horaAtual.getHours();
                    int hi = horaIniciais.get(i).getHours();
                    int hf = horaFinais.get(i).getHours();

                    Log.i("salaLivre", "hora atual: " + h + " horaInicial: " + hi + " horaFinal: " + hf);
                    if (h >= hi  && h <= hf ) {
                        Log.i("salaLivre","return false");
                        return false;
                    }
                }

                return true;

            }catch (Exception e){
                Log.i("salaLivre", "Deu mera");
                e.printStackTrace();
            }
        }

        return false;
    }


    public boolean apagarProfessor(String p){

        try{
            Professor professor = professorDao.load(p);
            professorDao.delete(professor);

            Log.i("apagarProfessor","funcionou apagarProfessor");
            return true;
        }catch (Exception e){
            Log.i("apagarProfessor","deu mera apagarProfessor");
            return false;
        }

    }
    public boolean apagarAluno(String a){

        try{
            Aluno aluno = alunoDao.load(a);
            alunoDao.delete(aluno);

            Log.i("apagaraluno","funcionou apagaraluno");
            return true;
        }catch (Exception e){
            Log.i("apagaraluno","deu mera apagaraluno");
            return false;
        }
    }

    public boolean apagarFuncionario(String f){

        try{
            Funcionario funcionario = funcionarioDao.load(f);
            funcionarioDao.delete(funcionario);

            Log.i("apagarfuncionario","funcionou apagarfuncionario");
            return true;
        }catch (Exception e){
            Log.i("apagarfuncionario","deu mera apagarfuncionario");
            return false;
        }
    }
    public boolean apagarSala(String s){

        try{
            Sala sala = salaDao.load(s);
            salaDao.delete(sala);

            Log.i("apagarsala","funcionou apagarsala");
            return true;
        }catch (Exception e){
            Log.i("apagarsala","deu mera apagarsala");
            return false;
        }
    }

    public boolean apagarDepartamento(String d){
        try{
            Departamento departamento = departamentoDao.load(d);
            departamentoDao.delete(departamento);

            Log.i("apagardepartamento","funcionou apagardepartamento");
            return true;
        }catch (Exception e){
            Log.i("apagardepartamento","deu mera apagardepartamento");
            return false;
        }

    }

    public boolean apagarCentro(String c){

        try{
            Centro centro = centroDao.load(c);
            centroDao.delete(centro);

            Log.i("apagarcentro","funcionou apagarcentro");
            return true;
        }catch (Exception e){
            Log.i("apagarcentro","deu mera apagarcentro");
            return false;
        }
    }

    public boolean atualizarProfessor(Professor p){
        try {
            Professor novo = professorDao.load(p.getCodigo());
            professorDao.update(novo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizarAluno(Aluno a){

        try {
            Aluno novo = alunoDao.load(a.getMatricula());
            alunoDao.update(novo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizarFuncionario(Funcionario f){

        try {
            Funcionario novo = funcionarioDao.load(f.getCodigo());
            funcionarioDao.update(novo);
            return true;
        }catch (Exception e){
            e.printStackTrace();;
            return false;
        }
    }
    public boolean atualizarSala(Sala s){

        try {
            Sala novo = salaDao.load(s.getNome());
            salaDao.update(novo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizarDepartamento(Departamento d){

        try {
            Departamento novo = departamentoDao.load(d.getNome());
            departamentoDao.update(novo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarCentro(Centro c){

        try{

            Centro centro = centroDao.load(c.getNome());
            centroDao.update(centro);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean alugarSala(String nomeDaSala, Date dataInicial, Date dataFinal,Date horaInicial,
                          Date horaFinal, int capacidade) {


        Sala sala = getSala(nomeDaSala);
        Aluga novoAluga;

        List<Aluga> alugas = sala.getAlugar_ids();

        try {
            if (alugas.size() <= 0) {

                novoAluga = new Aluga(null, dataInicial, dataFinal, horaInicial, horaFinal,
                        capacidade, sala.getUso(), nomeDaSala, codigo);
                alugaDao.insert(novoAluga);
                Log.i("alugarSala", "Inseriu com sucesso, tamanho 0");
                return true;
            }
        }catch (Exception e){

            Log.i("alugarSala","Deu mera 1");
            e.printStackTrace();
        }
        if (alugas.size() > 0){
            try {
                List<Date> horaIniciais = new ArrayList<Date>();
                List<Date> horaFinais = new ArrayList<Date>();

                Log.i("alugarSala", "Ano inicial: " + dataInicial.getYear() + " Mes inicial: " + dataInicial.getMonth() +
                " dia inicial: " + dataInicial.getDate());
                for (Aluga a : alugas) {

                    Log.i("alugarSala", "Ano inicial c: " + a.getDia_inicial().getYear() + " Mes inicial c: " +
                            a.getDia_inicial().getMonth() +  " dia inicial c: " + a.getDia_inicial().getDate());
                    if ((a.getDia_inicial().before(dataFinal) || a.getDia_inicial().equals(dataFinal)) &&
                            (a.getDia_termino().after(dataInicial) || a.getDia_termino().equals(dataInicial))) {

                        horaIniciais.add(a.getHora_inicial());
                        horaFinais.add(a.getHora_termino());
                    }
                }

                if (horaIniciais.size() <= 0) {

                    novoAluga = new Aluga(null, dataInicial, dataFinal, horaInicial, horaFinal,
                            capacidade, sala.getUso(), nomeDaSala, codigo);
                    alugaDao.insert(novoAluga);
                    Log.i("alugarSala","Inseriu com sucesso, hora iniciais vazio");
                    return true;
                }

                int tamanho = horaIniciais.size();

                for (int i = 0; i < tamanho; i++) {

                    int hi = horaInicial.getHours();
                    int hf = horaFinal.getHours();
                    int hic = horaIniciais.get(0).getHours();
                    int hfc = horaFinais.get(0).getHours();

                    Log.i("alugarSala", "hi: " + hi + " hf: " + hf + " hic: " + hic + " hfc: " + hfc);

                    if ( hic <= hf  && hfc >= hi ) {

                        Log.i("alugarSala","Encontrou ponto de intersecao");
                        return false;
                    }
                    novoAluga = new Aluga(null, dataInicial, dataFinal, horaInicial, horaFinal,
                            capacidade, sala.getUso(), nomeDaSala, codigo);
                    alugaDao.insert(novoAluga);
                    Log.i("alugarSala", "Inseriu com sucesso, depois do segundo for");
                    return true;
                }
            }catch (Exception e){

                Log.i("alugarSala","Deu mera 2");
                e.printStackTrace();
            }
        }

        return false;
    }

    public Professor getProfessor(String matricula){
        return professorDao.load(matricula);
    }

    public Aluno getAluno(String matricula){
        return alunoDao.load(matricula);
    }

    public Funcionario getFuncionario(String matricula){
        return funcionarioDao.load(matricula);
    }

    public Sala getSala(String nomeDaSala){
        return salaDao.load(nomeDaSala);
    }

    public void colocarSalasNaLista(Context context,ListView listView){

        List<Sala> salas = getAllSalas();

        nomes = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,nomes){

            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                ((TextView)view).setTextColor(Color.WHITE);

                return view;

            }
        };

        listView.setAdapter(arrayAdapter);

        if(salas.size() != 0){

            for (Sala s : salas) {
                nomes.add(s.getNome());
            }
        }
    }

    protected Comando(){}

    public static Comando getInstancia(){
        if(instancia == null) {
            instancia = new Comando();
        }

        return instancia;
    }

    protected void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void criarBanco(Context context){


        helper = new DaoMaster.DevOpenHelper(context,"rentaroom.db", null);
        database = helper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public void criarTables(){

        alunoDao = daoSession.getAlunoDao();
        centroDao = daoSession.getCentroDao();
        departamentoDao = daoSession.getDepartamentoDao();
        funcionarioDao = daoSession.getFuncionarioDao();
        gerenteDao = daoSession.getGerenteDao();
        professorDao = daoSession.getProfessorDao();
        salaDao = daoSession.getSalaDao();
        alugaDao = daoSession.getAlugaDao();
        alunoSigaaDao = daoSession.getAlunoSigaaDao();
        professorSigaaDao = daoSession.getProfessorSigaaDao();
        funcionarioSigaaDao = daoSession.getFuncionarioSigaaDao();
    }

    public void addUsuario(String matricula,String nome,String telefone,String cpf,String login,
                           String senha,String email, String tipo, String nomeDepartamento){


        try{
            if(tipo.equals("aluno") || tipo.equals("Aluno")) {
                Aluno novoAluno = new Aluno(matricula, nome, telefone, cpf, login, senha, email);
                alunoDao.insert(novoAluno);
                Log.i("addUsuario", "cadastro aluno com sucesso!");

            }else if(tipo.equals("professor") || tipo.equals("Professor")) {
                Professor novoProfessor = new Professor(matricula,nome,telefone,cpf,login,senha,email,nomeDepartamento);
                professorDao.insert(novoProfessor);
                Log.i("addUsuario", "cadastro professor com sucesso!");

            }else if(tipo.equals("funcionario") || tipo.equals("Funcionario")) {
                Funcionario novoFuncionario = new Funcionario(matricula, nome, telefone, cpf, login, senha, email);
                funcionarioDao.insert(novoFuncionario);
                Log.i("addUsuario", "cadastro funcionario com sucesso!");
            }

        }catch (Exception e){

            Log.i("addUsuario","Deu mera ao inserir usuario");
            e.printStackTrace();

        }
    }

    public int logar(String login, String senha){

        try{

            List<Gerente> gerentes = gerenteDao.loadAll();

            for(Gerente g : gerentes){

                if(g.getLogin().equals(login)){
                    if(g.getSenha().equals(senha)){
                        setCodigo("gerente");
                        setTipo("gerente");
                        Log.i("logar","logei como gerente");
                        return 1;
                    }
                }
            }

            List<Aluno> alunos = alunoDao.loadAll();

            for(Aluno g : alunos){

                if(g.getLogin().equals(login)){
                    if(g.getSenha().equals(senha)){
                        setCodigo(g.getMatricula());
                        setTipo("aluno");
                        Log.i("logar","logei como aluno");
                        return 2;
                    }
                }
            }

            List<Professor> professors = professorDao.loadAll();

            for(Professor g : professors){

                if(g.getLogin().equals(login)){
                    if(g.getSenha().equals(senha)){
                        setCodigo(g.getCodigo());
                        setTipo("professor");
                        Log.i("logar","logei como professor");
                        return 2;
                    }
                }
            }

            List<Funcionario> funcionarios = funcionarioDao.loadAll();

            for(Funcionario g : funcionarios){

                if(g.getLogin().equals(login)){
                    if(g.getSenha().equals(senha)){
                        setCodigo(g.getCodigo());
                        setTipo("funcionario");
                        Log.i("logar","logei como funcionario");
                        return 2;
                    }
                }
            }

        }catch (Exception e){

            Log.i("logar","Deu mera ao logar-se");
            e.printStackTrace();
        }

        return 0;
    }

    public void addGerente(String login, String senha){

        try{

            Gerente novoGerente = new Gerente(login,senha);

            gerenteDao.insert(novoGerente);
            Log.i("addGerente","inseriu gerente");

        }catch (Exception e){


            Log.i("addGerente","Deu mera ao inserir gerente");
            e.printStackTrace();
        }
    }

    public void addCentro(Context context, String nome, String telefone, String localizacao){

        try{

            Centro novoCentro = new Centro(nome,telefone,localizacao);
            centroDao.insert(novoCentro);
            Toast.makeText(context, "Inseriu o centro com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addCentro", "Inseriou o centro");
        }catch (Exception e){


            Toast.makeText(context, "Erro ao inserir o centro com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addCentro", "Erro ao inserir centro");
            e.printStackTrace();
        }
    }

    public void addDepartamento(Context context, String nome, String telefone, String email, String centroId){

        try{

            Departamento novoDepartamento = new Departamento(nome,email,telefone,centroId);
            departamentoDao.insert(novoDepartamento);

            Toast.makeText(context, "Inseriu o departamento com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addDepartamento", " inserio com sucesso");

        }catch (Exception e){
            Toast.makeText(context, "Erro ao inserir o departamento com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addDepartamento", " erro ao inseriri");
            e.printStackTrace();
        }
    }

    public void addSala(Context context, String uso, String localizacao, int capacidade, String nome,
                        String nomeDepartamento){

        try{

            Sala novoSala = new Sala(nome,uso,localizacao,capacidade,nomeDepartamento);

            salaDao.insert(novoSala);

            Toast.makeText(context, "Inseriu a sala com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addSala", " inserio com sucesso");

        }catch (Exception e){
            Toast.makeText(context, "Erro ao inserir a sala com Sucesso!",Toast.LENGTH_SHORT).show();
            Log.i("addSala", " erro ao inseriri");
            e.printStackTrace();
        }
    }

    public List<Sala> getAllSalas(){
        return salaDao.loadAll();
    }

    public Sala getSalaId(String nome){
        return salaDao.load(nome);
    }

    public String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void gerarSigaa() {

        try{
            ProfessorSigaa p;
            FuncionarioSigaa f;
            AlunoSigaa a;

            p = new ProfessorSigaa("1111", "Romero", "6666");
            professorSigaaDao.insert(p);

            p = new ProfessorSigaa("2222", "ACC", "6662");
            professorSigaaDao.insert(p);

            p = new ProfessorSigaa("3333", "Hamilton", "1010");
            professorSigaaDao.insert(p);

            f = new FuncionarioSigaa("1234", "Cara da rede", "0000");
            funcionarioSigaaDao.insert(f);

            f = new FuncionarioSigaa("5678", "Cara da limpeza", "7777");
            funcionarioSigaaDao.insert(f);

            f = new FuncionarioSigaa("9101", "Cara da van", "9999");
            funcionarioSigaaDao.insert(f);

            a = new AlunoSigaa("1132", "Wellton", "2213");
            alunoSigaaDao.insert(a);

            a = new AlunoSigaa("1131", "Abraao", "0987");
            alunoSigaaDao.insert(a);

            a = new AlunoSigaa("1122", "Zezinho", "0101");
            alunoSigaaDao.insert(a);

            Log.i("GerarSigaa","Adicionou todos do sigaa");

        }catch (Exception e){

            Log.i("addUsuario","Deu mera ao inserir usuario");
            e.printStackTrace();

        }

    }


    public boolean buscarNoSigaa(String matricula, String nome, String cpf){

        try{

            List<AlunoSigaa> alunoSigaas = alunoSigaaDao.loadAll();

            for(AlunoSigaa a : alunoSigaas){

                if(a.getCodigo().equals(matricula))
                    if(a.getNome().equals(nome))
                        if(a.getCpf().equals(cpf))
                            return true;
            }

            List<ProfessorSigaa> professorSigaas = professorSigaaDao.loadAll();

            for(ProfessorSigaa p : professorSigaas){

                if(p.getCodigo().equals(matricula))
                    if(p.getNome().equals(nome))
                        if(p.getCpf().equals(cpf))
                            return true;
            }

            List<FuncionarioSigaa> funcionarioSigaas = funcionarioSigaaDao.loadAll();

            for(FuncionarioSigaa f : funcionarioSigaas){

                if(f.getCodigo().equals(matricula))
                    if(f.getNome().equals(nome))
                        if(f.getCpf().equals(cpf))
                            return true;
            }

            return false;


        }catch (Exception e){

            Log.i("buscarNoSigaa","Deu mera no buscarNoSigaa");
            e.printStackTrace();
        }

        return false;
    }
}
