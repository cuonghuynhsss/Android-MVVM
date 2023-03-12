package com.cuonghuynh.myapplication.data.local;

import androidx.lifecycle.LiveData;

import com.cuonghuynh.myapplication.data.local.model.Cast;
import com.cuonghuynh.myapplication.data.local.model.Movie;
import com.cuonghuynh.myapplication.data.local.model.MovieDetails;
import com.cuonghuynh.myapplication.data.local.model.Review;
import com.cuonghuynh.myapplication.data.local.model.Trailer;
import com.cuonghuynh.myapplication.utils.AppExecutors;

import java.util.List;

import timber.log.Timber;

/**
 * @author Yassin Ajdi.
 */
public class MoviesLocalDataSource {

    private static volatile MoviesLocalDataSource sInstance;

    private final MoviesDatabase mDatabase;

    private MoviesLocalDataSource(MoviesDatabase database) {
        mDatabase = database;
    }

    public static MoviesLocalDataSource getInstance(MoviesDatabase database) {
        if (sInstance == null) {
            synchronized (AppExecutors.class) {
                if (sInstance == null) {
                    sInstance = new MoviesLocalDataSource(database);
                }
            }
        }
        return sInstance;
    }

    public void saveMovie(Movie movie) {
        mDatabase.moviesDao().insertMovie(movie);
        insertTrailers(movie.getTrailersResponse().getTrailers(), movie.getId());
        insertCastList(movie.getCreditsResponse().getCast(), movie.getId());
        insertReviews(movie.getReviewsResponse().getReviews(), movie.getId());
    }

    private void insertReviews(List<Review> reviews, long movieId) {
        for (Review review : reviews) {
            review.setMovieId(movieId);
        }
        mDatabase.reviewsDao().insertAllReviews(reviews);
        Timber.d("%s reviews inserted into database.", reviews.size());
    }

    private void insertCastList(List<Cast> castList, long movieId) {
        for (Cast cast : castList) {
            cast.setMovieId(movieId);
        }
        mDatabase.castsDao().insertAllCasts(castList);
        Timber.d("%s cast inserted into database.", castList.size());
    }

    private void insertTrailers(List<Trailer> trailers, long movieId) {
        for (Trailer trailer : trailers) {
            trailer.setMovieId(movieId);
        }
        mDatabase.trailersDao().insertAllTrailers(trailers);
        Timber.d("%s trailers inserted into database.", trailers.size());
    }

    public LiveData<MovieDetails> getMovie(long movieId) {
        Timber.d("Loading movie details.");
        return mDatabase.moviesDao().getMovie(movieId);
    }

    public LiveData<List<Movie>> getAllFavoriteMovies() {
        return mDatabase.moviesDao().getAllFavoriteMovies();
    }

    public void favoriteMovie(Movie movie) {
        mDatabase.moviesDao().favoriteMovie(movie.getId());
    }

    public void unfavoriteMovie(Movie movie) {
        mDatabase.moviesDao().unFavoriteMovie(movie.getId());
    }
}
