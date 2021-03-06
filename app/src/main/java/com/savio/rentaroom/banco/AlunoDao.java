package com.savio.rentaroom.banco;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.savio.rentaroom.banco.Aluno;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALUNO".
*/
public class AlunoDao extends AbstractDao<Aluno, String> {

    public static final String TABLENAME = "ALUNO";

    /**
     * Properties of entity Aluno.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Matricula = new Property(0, String.class, "matricula", true, "MATRICULA");
        public final static Property Nome = new Property(1, String.class, "nome", false, "NOME");
        public final static Property Telefone = new Property(2, String.class, "telefone", false, "TELEFONE");
        public final static Property Cpf = new Property(3, String.class, "cpf", false, "CPF");
        public final static Property Login = new Property(4, String.class, "login", false, "LOGIN");
        public final static Property Senha = new Property(5, String.class, "senha", false, "SENHA");
        public final static Property Email = new Property(6, String.class, "email", false, "EMAIL");
    };

    private DaoSession daoSession;


    public AlunoDao(DaoConfig config) {
        super(config);
    }
    
    public AlunoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALUNO\" (" + //
                "\"MATRICULA\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: matricula
                "\"NOME\" TEXT," + // 1: nome
                "\"TELEFONE\" TEXT," + // 2: telefone
                "\"CPF\" TEXT," + // 3: cpf
                "\"LOGIN\" TEXT," + // 4: login
                "\"SENHA\" TEXT," + // 5: senha
                "\"EMAIL\" TEXT);"); // 6: email
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALUNO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Aluno entity) {
        stmt.clearBindings();
 
        String matricula = entity.getMatricula();
        if (matricula != null) {
            stmt.bindString(1, matricula);
        }
 
        String nome = entity.getNome();
        if (nome != null) {
            stmt.bindString(2, nome);
        }
 
        String telefone = entity.getTelefone();
        if (telefone != null) {
            stmt.bindString(3, telefone);
        }
 
        String cpf = entity.getCpf();
        if (cpf != null) {
            stmt.bindString(4, cpf);
        }
 
        String login = entity.getLogin();
        if (login != null) {
            stmt.bindString(5, login);
        }
 
        String senha = entity.getSenha();
        if (senha != null) {
            stmt.bindString(6, senha);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
    }

    @Override
    protected void attachEntity(Aluno entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Aluno readEntity(Cursor cursor, int offset) {
        Aluno entity = new Aluno( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // matricula
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nome
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // telefone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // cpf
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // login
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // senha
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // email
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Aluno entity, int offset) {
        entity.setMatricula(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setNome(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTelefone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCpf(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLogin(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSenha(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEmail(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Aluno entity, long rowId) {
        return entity.getMatricula();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Aluno entity) {
        if(entity != null) {
            return entity.getMatricula();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
