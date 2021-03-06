package com.savio.rentaroom.banco;

import java.util.List;
import com.savio.rentaroom.banco.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SALA".
 */
public class Sala {

    private String nome;
    private String uso;
    private String localizacao;
    private Integer capacidade;
    private String departamento_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient SalaDao myDao;

    private List<Aluga> alugar_ids;

    public Sala() {
    }

    public Sala(String nome) {
        this.nome = nome;
    }

    public Sala(String nome, String uso, String localizacao, Integer capacidade, String departamento_id) {
        this.nome = nome;
        this.uso = uso;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.departamento_id = departamento_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSalaDao() : null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(String departamento_id) {
        this.departamento_id = departamento_id;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Aluga> getAlugar_ids() {
        if (alugar_ids == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlugaDao targetDao = daoSession.getAlugaDao();
            List<Aluga> alugar_idsNew = targetDao._querySala_Alugar_ids(nome);
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
