package com.deanlu.mybudget.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.deanlu.mybudget.Controllers.UserController;
import com.deanlu.mybudget.Models.User;
import com.deanlu.mybudget.R;

import java.util.Date;

/**
 * Created by Deimer on 15/06/2015.
 * ----------------------------------------------------
 * Clase controladora de la vista principal
 * encargada de manejar y gestionar los procesos
 * de la vista principal
 */
public class Principal extends Activity{

    private UserController userController = new UserController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        guardarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void guardarDatos(){
        try {
            User user = new User();
            user.setFirst_name("Deimer");
            user.setLast_name("Villa");
            user.setGender("Masculino");
            user.setEmail("deimer215@gmail.com");
            user.setBirthdate(new Date());
            user.setUsername("dvilla1");
            user.setPassword("05050707");
            userController.create(user, this.getApplicationContext());
            Log.i("Mensaje", "Guardado con exito");
        }catch (Exception ex){
            Log.e("Error al guardar","Error: "+ex.toString());
        }
    }

}
