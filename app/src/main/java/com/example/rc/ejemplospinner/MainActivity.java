package com.example.rc.ejemplospinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner1;
    private List<String> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatosPorDefecto();
        final EditText edttxt = (EditText) findViewById (R.id.editText1);
        Button btm_agregar = (Button) findViewById (R.id.btm_agregar);
        btm_agregar.setOnClickListener(new View.OnClickListener(){

     @Override
     public void onClick(View arg0) {
     String nuevoDato = edttxt.getText().toString();
     nuevoDato=nuevoDato.trim();
     if (nuevoDato.length()>1){
     lista.add(nuevoDato);
     edttxt.setText("");
                }
            }
        });

    }

    private void DatosPorDefecto() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        lista = new ArrayList<String>();
        spinner1 = (Spinner) this.findViewById(R.id.spinner1);
        lista.add("");
        lista.add("Acacia");
        lista.add("Azucena");
        lista.add("Dalia");
        lista.add("Girasol");
        lista.add("Lirio");
        lista.add("Horquidia");
        lista.add("Clavel");
        lista.add("Margarita");
        lista.add("Alcatraz");
        lista.add("Violeta");
        lista.add("Tulepan");




        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

     @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(arg0.getContext(), "Seleccionado: " + arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
            }

     @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
