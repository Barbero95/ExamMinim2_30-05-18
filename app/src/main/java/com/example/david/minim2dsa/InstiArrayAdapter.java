package com.example.david.minim2dsa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstiArrayAdapter extends ArrayAdapter<Libro> {
    public InstiArrayAdapter(@NonNull Context context, List<Libro> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Libro u = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_layout, parent, false);
        }
        //u.getImage()
        Picasso.with(super.getContext()).load("http://api.dsamola.tk/imagen.jpeg").into((ImageView) convertView.findViewById(R.id.avatar_image));
        Log.d("url",u.getImage());
        TextView et = (TextView)convertView.findViewById(R.id.author_txt);
        TextView et2 = (TextView)convertView.findViewById(R.id.title_txt);

        et.setText(u.getAuthor()); //cojo los nombres de los institutos
        //int x = u.getTitle();
        //et2.setText(Integer.toString(x));
        et2.setText(u.getTitle());
        return convertView;
    }
}
