package com.deanlu.mybudget.Controllers;

import android.content.Context;
import android.util.Log;
import com.deanlu.mybudget.Database.DatabaseHelper;
import com.deanlu.mybudget.Models.Entry;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by Deimer on 19/06/2015.
 * ----------------------------------------------------
 * Esta clase es la encargada de manejar las funciones
 * de la logica de los datos del modelo Entry(Ingresos)
 * que se tiene que llevar a cabo por la aplicación.
 */
public class EntryController {

    //Variable que permite traer las funciones de la base de datos
    DatabaseHelper dbHelper;

    //Funcion que permite la creacion de un ingreso nuevo
    public boolean create(Entry entry,Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
            RuntimeExceptionDao<Entry, Integer> entryDao = dbHelper.getEntryRuntimeDao();
            entryDao.create(entry);
        } catch (Exception ex) {
            res = false;
            Log.e("EntryController(create)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite el actualizar los datos de un ingreso
    public boolean update(Entry entry, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Entry, Integer> entryDao = dbHelper.getEntryRuntimeDao();
            entryDao.update(entry);
        } catch (Exception ex) {
            res = false;
            Log.e("EntryController(update)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite eliminar un ingreso de la base de datos
    public boolean delete(Entry entry, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Entry, Integer> entryDao = dbHelper.getEntryRuntimeDao();
            entryDao.delete(entry);
        } catch (Exception ex) {
            res = false;
            Log.e("EntryController(delete)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite la busqueda de un ingreso mediante el id de un usuario
    public Entry detail(int user_id, Context context){
        Entry entry;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Entry, Integer> entryDao = dbHelper.getEntryRuntimeDao();
            entry = entryDao.queryForId(user_id);
        } catch (Exception ex) {
            entry = null;
            Log.e("EntryController(detail)", "Error: " + ex.toString());
        }
        return entry;
    }

}
