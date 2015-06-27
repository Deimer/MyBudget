package com.deanlu.mybudget.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.deanlu.mybudget.Controllers.UserController;
import com.deanlu.mybudget.Database.DatabaseHelper;
import com.deanlu.mybudget.Models.User;
import com.deanlu.mybudget.R;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import java.util.Date;

public class Formulario extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

}
