package com.savio.rentaroom.banco;

import java.util.List;
import com.savio.rentaroom.banco.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ALUNO".
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String telefone;
    private String cpf;
    private String login;
    private String senha;
    private String email;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient AlunoDao myDao;

    private List<Aluga> alugar_ids;

    public Aluno() {
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String matricula, String nome, String telefone, String cpf, String login, String senha, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAlunoDao() : null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Aluga> getAlugar_ids() {
        if (alugar_ids == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlugaDao targetDao = daoSession.getAlugaDao();
            List<Aluga> alugar_idsNew = targetDao._queryAluno_Alugar_ids(matricula);
            synchronized (this) {
                if(alugar_ids == null) {
                    alugar_ids = alugar_idsNew;
                }
            }
        }
        return alugar_ids;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetAlugar_ids() {
        alugar_ids = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
