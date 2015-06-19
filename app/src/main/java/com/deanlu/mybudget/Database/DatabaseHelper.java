package com.deanlu.mybudget.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.deanlu.mybudget.Models.Entry;
import com.deanlu.mybudget.Models.Outgo;
import com.deanlu.mybudget.Models.User;
import com.deanlu.mybudget.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/**
 * Created by Deimer on 17/06/2015.
 * ----------------------------------------------------
 * Esta clase es la encargada de administrar la creacion y actualizacion
 * la base de datos usando el patron de disenios DAO (Data Access Object).
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    //Variables que manejaran la informacion estadar de la base de datos
    private static final String DATABASE_NAME = "mybudget.db";
    private static final int DATABASE_VERSION = 1;
    //Variables manejadoras de las funciones de la libreria ORMLite
    private Dao<User, Integer> userDAO = null;
    private Dao<Entry, Integer> entryDAO = null;
    private Dao<Outgo, Integer> outgoDAO = null;
    private RuntimeExceptionDao<User, Integer> userRuntimeDao = null;
    private RuntimeExceptionDao<Entry, Integer> entryRuntimeDao = null;
    private RuntimeExceptionDao<Outgo, Integer> outgoRuntimeDao = null;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION, R.raw.ormlite_config);
    }

    /*Funcion que permite crear la base de datos junto con sus tablas
    * Usa como parametros;
    * @param db
    * @param source
    */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource source){
        try{
            TableUtils.createTable(source, User.class);
            TableUtils.createTable(source,Entry.class);
            TableUtils.createTable(source,Outgo.class);
        }catch (SQLException sqlEx){
            Log.e("DatabaseHelper(onCreate)", "Error: " + sqlEx);
            throw new RuntimeException(sqlEx);
        }
    }

    /*Funcion que permite actualizar la base de datos cuando sea necesario
    * Usa como parametros;
    * @param db
    * @param source
    * @param oldVersion
    * @param newVersion
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion){
        try {
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, Entry.class, true);
            TableUtils.dropTable(source, Outgo.class, true);
            onCreate(db, source);
        }catch (SQLException sqlEx){
            Log.e("DatabaseHelper(onUpgrade)", "Error: " + sqlEx);
            throw new RuntimeException(sqlEx);
        }
    }

    /*Funcion que permite cerrar la conexion a la base de datos.
    * No usa parametros
    */
    @Override
    public void close(){
        super.close();
        userDAO = null;
        entryDAO = null;
        outgoDAO = null;
        userRuntimeDao = null;
        entryRuntimeDao = null;
        outgoRuntimeDao = null;
    }

    public Dao<User, Integer> getUserDAO()throws SQLException{
        if(userDAO==null) userDAO = getDao(User.class);
        return userDAO;
    }
    public Dao<Entry, Integer> getEntryDAO()throws SQLException{
        if(entryDAO==null) entryDAO = getDao(Entry.class);
        return entryDAO;
    }
    public Dao<Outgo, Integer> getOutgoDAO()throws SQLException{
        if(outgoDAO==null) outgoDAO = getDao(Outgo.class);
        return outgoDAO;
    }
    public RuntimeExceptionDao<User, Integer> getUserRuntimeDao() {
        if(userRuntimeDao==null) userRuntimeDao = getRuntimeExceptionDao(User.class);
        return userRuntimeDao;
    }
    public RuntimeExceptionDao<Entry, Integer> getEntryRuntimeDao() {
        if(entryRuntimeDao==null) entryRuntimeDao = getRuntimeExceptionDao(Entry.class);
        return entryRuntimeDao;
    }
    public RuntimeExceptionDao<Outgo, Integer> getOutgoRuntimeDao() {
        if(outgoRuntimeDao==null) outgoRuntimeDao = getRuntimeExceptionDao(Outgo.class);
        return outgoRuntimeDao;
    }
}
