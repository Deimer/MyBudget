package com.deanlu.mybudget.Controllers;

import android.content.Context;
import android.util.Log;
import com.deanlu.mybudget.Database.DatabaseHelper;
import com.deanlu.mybudget.Models.Outgo;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by Deimer on 19/06/2015.
 * ----------------------------------------------------
 * Esta clase es la encargada de manejar las funciones
 * de la logica de los datos del modelo Outgo(Gasto)
 * que se tiene que llevar a cabo por la aplicación.
 */
public class OutgoController {

    //Variable que permite traer las funciones de la base de datos
    DatabaseHelper dbHelper;

    //Funcion que permite la creacion de un gasto nuevo
    public boolean create(Outgo outgo,Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
            RuntimeExceptionDao<Outgo, Integer> outgoDao = dbHelper.getOutgoRuntimeDao();
            outgoDao.create(outgo);
        } catch (Exception ex) {
            res = false;
            Log.e("OutgoController(create)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite el actualizar los datos de un gasto
    public boolean update(Outgo outgo, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Outgo, Integer> outgoDao = dbHelper.getOutgoRuntimeDao();
            outgoDao.update(outgo);
        } catch (Exception ex) {
            res = false;
            Log.e("OutgoController(update)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite eliminar un gasto de la base de datos
    public boolean delete(Outgo outgo, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Outgo, Integer> outgoDao = dbHelper.getOutgoRuntimeDao();
            outgoDao.delete(outgo);
        } catch (Exception ex) {
            res = false;
            Log.e("OutgoController(delete)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite la busqueda de un gasto mediante su id
    public Outgo detail(int id, Context context){
        Outgo outgo;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<Outgo, Integer> outgoDao = dbHelper.getOutgoRuntimeDao();
            outgo = outgoDao.queryForId(id);
        } catch (Exception ex) {
            outgo = null;
            Log.e("OutgoController(detail)", "Error: " + ex.toString());
        }
        return outgo;
    }

}
