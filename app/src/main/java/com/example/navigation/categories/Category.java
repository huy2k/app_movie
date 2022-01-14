package com.example.navigation.categories;

import com.example.navigation.movies.Movie;

import java.util.List;

public class Category {
    int id;
    String categoryName;
    List<Movie> movies;
    public Category(int id, String categoryName, List<Movie> movies) {
        this.id = id;
        this.categoryName = categoryName;
        this.movies = movies;
    }

    public Category(final String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
