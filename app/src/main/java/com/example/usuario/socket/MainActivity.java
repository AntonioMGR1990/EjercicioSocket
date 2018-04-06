package com.example.usuario.socket;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText nombre,apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        findViewById(R.id.btnEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre1 = nombre.getText().toString();
                String apellido1 = apellido.getText().toString();

                ComunicationTask com = new ComunicationTask();
                com.execute("10.225.92.140","9800",nombre1,apellido1);
            }
        });
    }
    private class ComunicationTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            BufferedReader bf=null;
            Socket sc=null;
            String res="";
            Persona persona = new Persona(params[2],params[3]);
            ObjectOutputStream fsalida;
            try {
                sc=new Socket(params[0],Integer.parseInt(params[1]));
                fsalida = new ObjectOutputStream(sc.getOutputStream());
                fsalida.writeObject(persona);
                fsalida.close();
                InputStream is=sc.getInputStream();
                bf=new BufferedReader(new InputStreamReader(is));
                res=bf.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(bf!=null){
                    try {
                        bf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(sc!=null){
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            //   super.onPostExecute(s);5




        }


    }
}
