package com.deanlu.mybudget.Controllers;

import android.content.Context;
import android.util.Log;
import com.deanlu.mybudget.Database.DatabaseHelper;
import com.deanlu.mybudget.Models.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by Deimer on 18/06/2015.
 * ----------------------------------------------------
 * Esta clase es la encargada de manejar las funciones
 * de la logica de los datos del modelo User(Usuario)
 * que se tiene que llevar a cabo por la aplicación.
 */
public class UserController {

    //Variable que permite traer las funciones de la base de datos
    DatabaseHelper dbHelper;

    //Funcion que permite la creacion de un usuario nuevo
    public boolean create(User user,Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = dbHelper.getUserRuntimeDao();
            userDao.create(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(create)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite el actualizar los datos de un usuario
    public boolean update(User user, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = dbHelper.getUserRuntimeDao();
            userDao.update(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(update)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite eliminar un usuario de la base de datos
    public boolean delete(User user, Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = dbHelper.getUserRuntimeDao();
            userDao.delete(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(delete)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite la busqueda de un usuario mediante su id
    public User detail(int id, Context context){
        User user;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = dbHelper.getUserRuntimeDao();
            user = userDao.queryForId(id);
        } catch (Exception ex) {
            user = null;
            Log.e("UserController(detail)", "Error: " + ex.toString());
        }
        return user;
    }

}