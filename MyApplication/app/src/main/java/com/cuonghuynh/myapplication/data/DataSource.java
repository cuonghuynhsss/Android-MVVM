package com.cuonghuynh.myapplication.data;

import androidx.lifecycle.LiveData;

import com.cuonghuynh.myapplication.data.local.model.Movie;
import com.cuonghuynh.myapplication.data.local.model.MovieDetails;
import com.cuonghuynh.myapplication.data.local.model.RepoMoviesResult;
import com.cuonghuynh.myapplication.data.local.model.Resource;
import com.cuonghuynh.myapplication.ui.movieslist.MoviesFilterType;

import java.util.List;

/**
 * @author Yassin Ajdi.
 */
public interface DataSource {

    LiveData<Resource<MovieDetails>> loadMovie(long movieId);

    RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy);

    LiveData<List<Movie>> getAllFavoriteMovies();

    void favoriteMovie(Movie movie);

    void unfavoriteMovie(Movie movie);
}
