package com.example.david.minim2dsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://api.dsamola.tk/";
    private TrackApi trackServices;
    ProgressBar pb1;
    String tag = "Events";
    private Call<List<Libro>> callInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (ProgressBar) findViewById(R.id.loading);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackServices = retrofit.create(TrackApi.class);
        iniciar();
    }

    public void iniciar(){
        pb1.setVisibility(ProgressBar.VISIBLE);
        callInicio = trackServices.listaLibros();
        callInicio.enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {

                    Log.d("onResponse", "lista ha llegado");
                    final List<Libro> listaLibros = response.body();
                    ListView lv = (ListView) findViewById(R.id.followers_list);
                    InstiArrayAdapter uaa = new InstiArrayAdapter(getApplicationContext(), listaLibros);
                    lv.setAdapter(uaa);
                    lv.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Object listItem = listaLibros.getItemAtPosition(position);
                            Intent i = new Intent(getApplicationContext(), MuestraLibro.class);
                            i.putExtra("id", listaLibros.get(position).get_id());
                            startActivity(i);
                        }
                    });
                        //al final de la tasca
                        pb1.setVisibility(ProgressBar.INVISIBLE);

                }
                else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText (MainActivity.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });

    }
    @Override
    protected void onStart (){
        super.onStart();
        Log.d(tag,"Event a onStart");
    }

    @Override
    protected void onResume (){
        super.onResume();
        Log.d(tag,"Event a onResume");
    }

    @Override
    protected void onPause (){
        super.onPause();
        Log.d(tag,"Event a onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (calltrack != null) {
//            calltrack.cancel();
//        }
//        if (callstring != null) {
//            callstring.cancel();
//        }

    }

    @Override
    protected void onDestroy (){
        super.onDestroy();
        Log.d(tag,"Event a onDestroy");
    }
}
