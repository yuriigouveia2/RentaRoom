package com.savio.rentaroom.generated;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class Main {

    public static void main(String[] args){

        Schema schema = new Schema(3,"com.savio.rentaroom.banco");

        Entity gerente = schema.addEntity("Gerente");
        gerente.addStringProperty("login").primaryKey().unique();
        gerente.addStringProperty("senha");

        Entity centro = schema.addEntity("Centro");
        centro.addStringProperty("nome").primaryKey().unique();
        centro.addStringProperty("telefone");
        centro.addStringProperty("localizacao");

        Entity departamento = schema.addEntity("Departamento");
        departamento.addStringProperty("nome").primaryKey().unique();
        departamento.addStringProperty("email");
        departamento.addStringProperty("telefone");
        Property departamentoId = departamento.addStringProperty("centro_id").getProperty();

        Entity aluga = schema.addEntity("Aluga");
        aluga.addIdProperty().autoincrement().unique();
        aluga.addDateProperty("dia_inicial");
        aluga.addDateProperty("dia_termino");
        aluga.addDateProperty("hora_inicial");
        aluga.addDateProperty("hora_termino");
        aluga.addIntProperty("quantidade_reservada");
        aluga.addStringProperty("finalidade");
        Property alugaId = aluga.addStringProperty("sala_id").getProperty();
        Property alugaId2 = aluga.addStringProperty("matricula_id").getProperty();

        Entity sala = schema.addEntity("Sala");
        sala.addStringProperty("nome").primaryKey().unique();
        sala.addStringProperty("uso");
        sala.addStringProperty("localizacao");
        sala.addIntProperty("capacidade");
        Property salaId = sala.addStringProperty("departamento_id").getProperty();

        ToMany salaParaAlugar = sala.addToMany(aluga,alugaId);
        salaParaAlugar.setName("alugar_ids");

        ToMany salasDoDepartamento = departamento.addToMany(sala, salaId);
        salasDoDepartamento.setName("salas_ids");

        Entity professor = schema.addEntity("Professor");
        professor.addStringProperty("codigo").primaryKey().unique();
        professor.addStringProperty("nome");
        professor.addStringProperty("telefone");
        professor.addStringProperty("cpf");
        professor.addStringProperty("login");
        professor.addStringProperty("senha");
        professor.addStringProperty("email");
        Property professorId = professor.addStringProperty("departamento_id").getProperty();

        ToMany idsAlugaProfessor = professor.addToMany(aluga,alugaId2);
        idsAlugaProfessor.setName("alugar_ids");

        ToMany professoresDoDepartamento = departamento.addToMany(professor, professorId);
        professoresDoDepartamento.setName("professores_ids");

        ToMany departamentoDoCentro = centro.addToMany(departamento, departamentoId);
        departamentoDoCentro.setName("departamentos_ids");


        Entity aluno = schema.addEntity("Aluno");
        aluno.addStringProperty("matricula").primaryKey().unique();
        aluno.addStringProperty("nome");
        aluno.addStringProperty("telefone");
        aluno.addStringProperty("cpf");
        aluno.addStringProperty("login");
        aluno.addStringProperty("senha");
        aluno.addStringProperty("email");

        ToMany idsAlugaAluno = aluno.addToMany(aluga,alugaId2);
        idsAlugaAluno.setName("alugar_ids");

        Entity funcionario = schema.addEntity("Funcionario");
        funcionario.addStringProperty("codigo").primaryKey().unique();
        funcionario.addStringProperty("nome");
        funcionario.addStringProperty("telefone");
        funcionario.addStringProperty("cpf");
        funcionario.addStringProperty("login");
        funcionario.addStringProperty("senha");
        funcionario.addStringProperty("email");

        ToMany idsAlugaFuncionario = funcionario.addToMany(aluga,alugaId2);
        idsAlugaFuncionario.setName("alugar_ids");

        Entity professorSigaa = schema.addEntity("ProfessorSigaa");
        professorSigaa.addStringProperty("codigo").primaryKey().unique();
        professorSigaa.addStringProperty("nome");
        professorSigaa.addStringProperty("cpf");

        Entity funcionarioSigaa = schema.addEntity("FuncionarioSigaa");
        funcionarioSigaa.addStringProperty("codigo").primaryKey().unique();
        funcionarioSigaa.addStringProperty("nome");
        funcionarioSigaa.addStringProperty("cpf");

        Entity alunoSigaa = schema.addEntity("AlunoSigaa");
        alunoSigaa.addStringProperty("codigo").primaryKey().unique();
        alunoSigaa.addStringProperty("nome");
        alunoSigaa.addStringProperty("cpf");

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
