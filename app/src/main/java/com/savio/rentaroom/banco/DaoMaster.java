package com.savio.rentaroom.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.savio.rentaroom.banco.GerenteDao;
import com.savio.rentaroom.banco.CentroDao;
import com.savio.rentaroom.banco.DepartamentoDao;
import com.savio.rentaroom.banco.AlugaDao;
import com.savio.rentaroom.banco.SalaDao;
import com.savio.rentaroom.banco.ProfessorDao;
import com.savio.rentaroom.banco.AlunoDao;
import com.savio.rentaroom.banco.FuncionarioDao;
import com.savio.rentaroom.banco.ProfessorSigaaDao;
import com.savio.rentaroom.banco.FuncionarioSigaaDao;
import com.savio.rentaroom.banco.AlunoSigaaDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 3): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 3;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        GerenteDao.createTable(db, ifNotExists);
        CentroDao.createTable(db, ifNotExists);
        DepartamentoDao.createTable(db, ifNotExists);
        AlugaDao.createTable(db, ifNotExists);
        SalaDao.createTable(db, ifNotExists);
        ProfessorDao.createTable(db, ifNotExists);
        AlunoDao.createTable(db, ifNotExists);
        FuncionarioDao.createTable(db, ifNotExists);
        ProfessorSigaaDao.createTable(db, ifNotExists);
        FuncionarioSigaaDao.createTable(db, ifNotExists);
        AlunoSigaaDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        GerenteDao.dropTable(db, ifExists);
        CentroDao.dropTable(db, ifExists);
        DepartamentoDao.dropTable(db, ifExists);
        AlugaDao.dropTable(db, ifExists);
        SalaDao.dropTable(db, ifExists);
        ProfessorDao.dropTable(db, ifExists);
        AlunoDao.dropTable(db, ifExists);
        FuncionarioDao.dropTable(db, ifExists);
        ProfessorSigaaDao.dropTable(db, ifExists);
        FuncionarioSigaaDao.dropTable(db, ifExists);
        AlunoSigaaDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(GerenteDao.class);
        registerDaoClass(CentroDao.class);
        registerDaoClass(DepartamentoDao.class);
        registerDaoClass(AlugaDao.class);
        registerDaoClass(SalaDao.class);
        registerDaoClass(ProfessorDao.class);
        registerDaoClass(AlunoDao.class);
        registerDaoClass(FuncionarioDao.class);
        registerDaoClass(ProfessorSigaaDao.class);
        registerDaoClass(FuncionarioSigaaDao.class);
        registerDaoClass(AlunoSigaaDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
