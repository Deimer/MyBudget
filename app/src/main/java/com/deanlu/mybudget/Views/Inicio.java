package com.deanlu.mybudget.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.view.Window;
import android.view.WindowManager;
import com.deanlu.mybudget.R;

public class Inicio extends Activity {

    public static final int segundos = 8;
    public static final int milisegundos = segundos*1000;
    private ProgressBar pbProgreso;
    private static final int delay = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio);
        inicializarElementosVista();
        inicializarProgreso();
    }

/**Funciones para inicializar los elementos en la vista
*****/
    public void inicializarElementosVista(){
        pbProgreso = (ProgressBar) findViewById(R.id.pbProgreso);
        pbProgreso.setMax(finalizarProgreso());
    }

/**Funciones encargadas del manejo de los recursos en la vista
*****/
    public void inicializarProgreso(){
        new CountDownTimer(milisegundos,1000) {
            public void onTick(long millisUntilFinished){
                pbProgreso.setProgress(startProgreso(millisUntilFinished));
            }
            public void onFinish(){
                Intent principal = new Intent(Inicio.this,Principal.class);
                startActivity(principal);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();
            }
        }.start();
    }

    public int startProgreso(long miliseconds){
        return (int)((milisegundos-miliseconds)/1000);
    }

    public int finalizarProgreso(){
        return (segundos-delay);
    }

}
