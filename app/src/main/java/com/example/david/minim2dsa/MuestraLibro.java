package com.example.david.minim2dsa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MuestraLibro extends AppCompatActivity {
    public static final String BASE_URL = "http://api.dsamola.tk/";
    private TrackApi trackServices;
    ProgressBar pb1;
    String tag = "Events";
    private Call<Libroinfo> callLibro;
    private String idLibro;
    private List<Comentario> comentarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_libro);
        Bundle intentdata = getIntent().getExtras();
        idLibro = intentdata.getString("id");

        pb1 = (ProgressBar) findViewById(R.id.loading);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        trackServices = retrofit.create(TrackApi.class);
        getLibro();
    }

    public void getLibro (){
        pb1.setVisibility(ProgressBar.VISIBLE);
        callLibro = trackServices.infoLibro(idLibro);
        callLibro.enqueue(new Callback<Libroinfo>() {
            @Override
            public void onResponse(Call<Libroinfo> call, Response<Libroinfo> response) {
                int statusCode = response.code();
                if (response.isSuccessful()) {

                    Log.d("onResponse", "lista ha llegado");
                    final Libroinfo libro = response.body();
                    comentarios = libro.getComments();
                    TextView et = (TextView)findViewById(R.id.author);
                    TextView et2 = (TextView)findViewById(R.id.title);
                    TextView et3 = (TextView)findViewById(R.id.description);
                    TextView et4 = (TextView)findViewById(R.id.date);
                    TextView et5 = (TextView)findViewById(R.id.publisher);
                    et.setText(libro.getAuthor());
                    et2.setText(libro.getTitle());
                    et3.setText(libro.getDescription());
                    et4.setText(libro.getDate());
                    et5.setText(libro.getPublisher());

                    ListView lv = (ListView) findViewById(R.id.comments);
                    CommentArrayAdapter uaa = new CommentArrayAdapter(getApplicationContext(), comentarios);
                    lv.setAdapter(uaa);
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);

                }
                else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText (MuestraLibro.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Libroinfo> call, Throwable t) {
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });

    }
}
