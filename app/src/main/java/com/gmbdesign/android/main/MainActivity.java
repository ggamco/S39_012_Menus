package com.gmbdesign.android.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //6º
        //TAMBIEN EXISTEN MENUS EMERGENTES CUANDO PULSAMOS UN BOTON
        Button boton = (Button) findViewById(R.id.button);

        /*
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EL CONSTRUCTOR PIDE CONTEXTO Y VISTA ASOCIADA
                PopupMenu p = new PopupMenu(MainActivity.this, v);
                //INFLAMOS EL LAYOUT MENU Y SE LOS ASOCIAMOS AL MENU DEL POPUP
                p.getMenuInflater().inflate(R.menu.menu_layout, p.getMenu());
                //MOSTRAMOS EL MENU EMERGENTE AL RECIBIR EL CLIC
                p.show();
            }
        });
        */

        //7º AlertDialog
        //PODEMOS PINTAR UN DIALOG DE LA SIGUIENTE MANERA
        //EL DIALOG ES UNA VENTANA EMERGENTE SUPERPUESTA SOBRE LA ACTIVIDAD PRINCIPAL
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.alert_dialog);
                dialog.show();
                */

                //8º TOAST PERSONALIZADO
                LinearLayout linear = new LinearLayout(MainActivity.this);
                TextView tv = new TextView(MainActivity.this);
                tv.setText("GOOOOL DEL RAYOOOO");
                tv.setTextColor(Color.BLUE);

                linear.addView(tv);

                Toast toast = new Toast(MainActivity.this);
                toast.setView(linear);

                toast.show();
            }
        });


    }

    //Si queremo mostrar el menu en la barra superior derecha, necesitamos
    // sobreescribir este metodo, onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        //1º
        //(agrupacion, id, posicion, texto)
        menu.add(Menu.NONE, 1, 1, "Hola");
        menu.add(Menu.NONE, 2, 2, "Adios");

        //3º
        //Podemos llamar generar acciones (INTENT) para setear a los botones del menu
        //si usamos este metodo para llamar acciones no debemos sobreescribir el metodo
        //onOptionsItemSelected() ya que este manda sobre los intent...
        MenuItem mi1 = menu.getItem(0); //comienza por la posicion 0, nada del id dado...
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
        mi1.setIntent(intent);

        //4º
        //podemos añadir submenus
        SubMenu sm = menu.addSubMenu(Menu.NONE, 4, 4, "SubMenu");
        MenuItem smitem = sm.add(Menu.NONE, 5, 5, "Tocar");
        smitem.setCheckable(true);

        */

        //5º
        //TAMBIEN PODEMOS INFLAR UN MENU ON THE FLY...
        //getMenuInflater().inflate(R.menu.menu_layout, menu);


        return  true;
    }

    //2º
    //si queremos que hagan alguna accion cuando pulsemos algun boton necesitamos
    // sobrescribir el siguiente metodo

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("MENUTOCADO TITULO = ", item.getTitle().toString());
        Log.e("MENUTOCADO ID = ", "" + item.getItemId());
        return true;
    }

    //9º
    //AQUI VEMOS COMO SE CREA UN ALERTDIALOG CON OPCIONES CUANDO PULSAMOS LA TECLA BACK
    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Salir");
        ad.setMessage("¿Desea salir?");

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad.setButton(AlertDialog.BUTTON_NEUTRAL, "NoSe", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });

        ad.show();
    }
}
