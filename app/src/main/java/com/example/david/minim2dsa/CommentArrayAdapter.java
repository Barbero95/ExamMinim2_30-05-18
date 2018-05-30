package com.example.david.minim2dsa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CommentArrayAdapter extends ArrayAdapter<Comentario> {
    public CommentArrayAdapter(@NonNull Context context, List<Comentario> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Comentario u = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment, parent, false);
        }
        //u.getImage()
        //Picasso.with(super.getContext()).load("http://api.dsamola.tk/imagen.jpeg").into((ImageView) convertView.findViewById(R.id.avatar_image));
        //Log.d("url",u.getImage());
        TextView et = (TextView)convertView.findViewById(R.id.user_txt);
        TextView et2 = (TextView)convertView.findViewById(R.id.message_txt);

        et.setText(u.getUser()); //cojo los nombres de los institutos
        //int x = u.getTitle();
        //et2.setText(Integer.toString(x));
        et2.setText(u.getMessage());
        return convertView;
    }
}
