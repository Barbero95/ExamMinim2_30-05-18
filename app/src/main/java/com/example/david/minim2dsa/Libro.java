package com.example.david.minim2dsa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Libro {
    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("_id")
    @Expose
    private String _id;

    public Libro() {
    }

    public Libro(String author, String title, String image, String _id) {
        this.author = author;
        this.title = title;
        this.image = image;
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
