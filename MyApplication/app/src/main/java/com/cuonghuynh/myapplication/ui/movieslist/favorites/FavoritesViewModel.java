package com.cuonghuynh.myapplication.ui.movieslist.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cuonghuynh.myapplication.data.MovieRepository;
import com.cuonghuynh.myapplication.data.local.model.Movie;

import java.util.List;

/**
 * @author Yassin Ajdi.
 */
public class FavoritesViewModel extends ViewModel {

    //    private final MovieRepository movieRepository;
    private LiveData<List<Movie>> favoriteListLiveData;

    public FavoritesViewModel(MovieRepository repository) {
        favoriteListLiveData = repository.getAllFavoriteMovies();
    }

    public LiveData<List<Movie>> getFavoriteListLiveData() {
        return favoriteListLiveData;
    }
}
