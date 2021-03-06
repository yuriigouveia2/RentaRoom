package com.savio.rentaroom.banco;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.savio.rentaroom.banco.Aluga;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALUGA".
*/
public class AlugaDao extends AbstractDao<Aluga, Long> {

    public static final String TABLENAME = "ALUGA";

    /**
     * Properties of entity Aluga.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Dia_inicial = new Property(1, java.util.Date.class, "dia_inicial", false, "DIA_INICIAL");
        public final static Property Dia_termino = new Property(2, java.util.Date.class, "dia_termino", false, "DIA_TERMINO");
        public final static Property Hora_inicial = new Property(3, java.util.Date.class, "hora_inicial", false, "HORA_INICIAL");
        public final static Property Hora_termino = new Property(4, java.util.Date.class, "hora_termino", false, "HORA_TERMINO");
        public final static Property Quantidade_reservada = new Property(5, Integer.class, "quantidade_reservada", false, "QUANTIDADE_RESERVADA");
        public final static Property Finalidade = new Property(6, String.class, "finalidade", false, "FINALIDADE");
        public final static Property Sala_id = new Property(7, String.class, "sala_id", false, "SALA_ID");
        public final static Property Matricula_id = new Property(8, String.class, "matricula_id", false, "MATRICULA_ID");
    };

    private Query<Aluga> sala_Alugar_idsQuery;
    private Query<Aluga> professor_Alugar_idsQuery;
    private Query<Aluga> aluno_Alugar_idsQuery;
    private Query<Aluga> funcionario_Alugar_idsQuery;

    public AlugaDao(DaoConfig config) {
        super(config);
    }
    
    public AlugaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALUGA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE ," + // 0: id
                "\"DIA_INICIAL\" INTEGER," + // 1: dia_inicial
                "\"DIA_TERMINO\" INTEGER," + // 2: dia_termino
                "\"HORA_INICIAL\" INTEGER," + // 3: hora_inicial
                "\"HORA_TERMINO\" INTEGER," + // 4: hora_termino
                "\"QUANTIDADE_RESERVADA\" INTEGER," + // 5: quantidade_reservada
                "\"FINALIDADE\" TEXT," + // 6: finalidade
                "\"SALA_ID\" TEXT," + // 7: sala_id
                "\"MATRICULA_ID\" TEXT);"); // 8: matricula_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALUGA\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Aluga entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date dia_inicial = entity.getDia_inicial();
        if (dia_inicial != null) {
            stmt.bindLong(2, dia_inicial.getTime());
        }
 
        java.util.Date dia_termino = entity.getDia_termino();
        if (dia_termino != null) {
            stmt.bindLong(3, dia_termino.getTime());
        }
 
        java.util.Date hora_inicial = entity.getHora_inicial();
        if (hora_inicial != null) {
            stmt.bindLong(4, hora_inicial.getTime());
        }
 
        java.util.Date hora_termino = entity.getHora_termino();
        if (hora_termino != null) {
            stmt.bindLong(5, hora_termino.getTime());
        }
 
        Integer quantidade_reservada = entity.getQuantidade_reservada();
        if (quantidade_reservada != null) {
            stmt.bindLong(6, quantidade_reservada);
        }
 
        String finalidade = entity.getFinalidade();
        if (finalidade != null) {
            stmt.bindString(7, finalidade);
        }
 
        String sala_id = entity.getSala_id();
        if (sala_id != null) {
            stmt.bindString(8, sala_id);
        }
 
        String matricula_id = entity.getMatricula_id();
        if (matricula_id != null) {
            stmt.bindString(9, matricula_id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Aluga readEntity(Cursor cursor, int offset) {
        Aluga entity = new Aluga( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // dia_inicial
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // dia_termino
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // hora_inicial
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // hora_termino
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // quantidade_reservada
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // finalidade
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // sala_id
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // matricula_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Aluga entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDia_inicial(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setDia_termino(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setHora_inicial(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setHora_termino(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setQuantidade_reservada(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setFinalidade(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSala_id(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMatricula_id(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Aluga entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Aluga entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "alugar_ids" to-many relationship of Sala. */
    public List<Aluga> _querySala_Alugar_ids(String sala_id) {
        synchronized (this) {
            if (sala_Alugar_idsQuery == null) {
                QueryBuilder<Aluga> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Sala_id.eq(null));
                sala_Alugar_idsQuery = queryBuilder.build();
            }
        }
        Query<Aluga> query = sala_Alugar_idsQuery.forCurrentThread();
        query.setParameter(0, sala_id);
        return query.list();
    }

    /** Internal query to resolve the "alugar_ids" to-many relationship of Professor. */
    public List<Aluga> _queryProfessor_Alugar_ids(String matricula_id) {
        synchronized (this) {
            if (professor_Alugar_idsQuery == null) {
                QueryBuilder<Aluga> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Matricula_id.eq(null));
                professor_Alugar_idsQuery = queryBuilder.build();
            }
        }
        Query<Aluga> query = professor_Alugar_idsQuery.forCurrentThread();
        query.setParameter(0, matricula_id);
        return query.list();
    }

    /** Internal query to resolve the "alugar_ids" to-many relationship of Aluno. */
    public List<Aluga> _queryAluno_Alugar_ids(String matricula_id) {
        synchronized (this) {
            if (aluno_Alugar_idsQuery == null) {
                QueryBuilder<Aluga> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Matricula_id.eq(null));
                aluno_Alugar_idsQuery = queryBuilder.build();
            }
        }
        Query<Aluga> query = aluno_Alugar_idsQuery.forCurrentThread();
        query.setParameter(0, matricula_id);
        return query.list();
    }

    /** Internal query to resolve the "alugar_ids" to-many relationship of Funcionario. */
    public List<Aluga> _queryFuncionario_Alugar_ids(String matricula_id) {
        synchronized (this) {
            if (funcionario_Alugar_idsQuery == null) {
                QueryBuilder<Aluga> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Matricula_id.eq(null));
                funcionario_Alugar_idsQuery = queryBuilder.build();
            }
        }
        Query<Aluga> query = funcionario_Alugar_idsQuery.forCurrentThread();
        query.setParameter(0, matricula_id);
        return query.list();
    }

}
