package com.savio.rentaroom.banco;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.savio.rentaroom.banco.FuncionarioSigaa;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FUNCIONARIO_SIGAA".
*/
public class FuncionarioSigaaDao extends AbstractDao<FuncionarioSigaa, String> {

    public static final String TABLENAME = "FUNCIONARIO_SIGAA";

    /**
     * Properties of entity FuncionarioSigaa.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Codigo = new Property(0, String.class, "codigo", true, "CODIGO");
        public final static Property Nome = new Property(1, String.class, "nome", false, "NOME");
        public final static Property Cpf = new Property(2, String.class, "cpf", false, "CPF");
    };


    public FuncionarioSigaaDao(DaoConfig config) {
        super(config);
    }
    
    public FuncionarioSigaaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FUNCIONARIO_SIGAA\" (" + //
                "\"CODIGO\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: codigo
                "\"NOME\" TEXT," + // 1: nome
                "\"CPF\" TEXT);"); // 2: cpf
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FUNCIONARIO_SIGAA\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, FuncionarioSigaa entity) {
        stmt.clearBindings();
 
        String codigo = entity.getCodigo();
        if (codigo != null) {
            stmt.bindString(1, codigo);
        }
 
        String nome = entity.getNome();
        if (nome != null) {
            stmt.bindString(2, nome);
        }
 
        String cpf = entity.getCpf();
        if (cpf != null) {
            stmt.bindString(3, cpf);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public FuncionarioSigaa readEntity(Cursor cursor, int offset) {
        FuncionarioSigaa entity = new FuncionarioSigaa( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // codigo
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nome
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // cpf
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, FuncionarioSigaa entity, int offset) {
        entity.setCodigo(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setNome(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCpf(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(FuncionarioSigaa entity, long rowId) {
        return entity.getCodigo();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(FuncionarioSigaa entity) {
        if(entity != null) {
            return entity.getCodigo();
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
