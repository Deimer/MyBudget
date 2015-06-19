package com.deanlu.mybudget.Controllers;

import android.content.Context;
import com.deanlu.mybudget.Database.DatabaseHelper;
import com.deanlu.mybudget.Models.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by Deimer on 18/06/2015.
 */
public class UserController {

    DatabaseHelper dbHelper;

    public boolean crearUsuario(User user,Context context){
        boolean res = true;
        try {
            dbHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = dbHelper.getUserRuntimeDao();
            userDao.create(user);
        } catch (Exception e) {
            res = false;
            e.printStackTrace();
        }
        return res;
    }

}
