package com.example.moviezenapp.ui.lists;

import androidx.lifecycle.ViewModel;

import com.example.moviezenapp.models.MovieList;

public class ListsViewModel extends ViewModel {

    private static ListsViewModel instance;
    private MovieList list;

    private ListsViewModel() {
    }

    public static synchronized ListsViewModel getInstance() {
        if (instance == null) {
            instance = new ListsViewModel();
        }
        return instance;
    }

    public MovieList getListOfMovies() {
        return list;
    }

    public void setListOfMovies(MovieList list) {
        this.list = list;
    }
}
