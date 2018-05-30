package com.example.david.minim2dsa;

import java.util.List;

public class Libroinfo {

    private String author;

    private String title;

    private String description;

    private String publisher;

    private String date;

    private String image;

    private int rating;

    private List<Comentario> comments;

    public Libroinfo() {
    }

    public Libroinfo(String author, String title, String description, String publisher, String date, String image, int rating, List<Comentario> comments) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.date = date;
        this.image = image;
        this.rating = rating;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Libroinfo{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", comments=" + comments +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Comentario> getComments() {
        return comments;
    }

    public void setComments(List<Comentario> comments) {
        this.comments = comments;
    }
}


