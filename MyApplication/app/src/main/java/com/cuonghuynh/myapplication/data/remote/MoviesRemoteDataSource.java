package com.cuonghuynh.myapplication.data.remote;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.cuonghuynh.myapplication.data.local.model.Movie;
import com.cuonghuynh.myapplication.data.local.model.RepoMoviesResult;
import com.cuonghuynh.myapplication.data.local.model.Resource;
import com.cuonghuynh.myapplication.data.remote.api.ApiResponse;
import com.cuonghuynh.myapplication.data.remote.api.MovieService;
import com.cuonghuynh.myapplication.data.remote.paging.MovieDataSourceFactory;
import com.cuonghuynh.myapplication.data.remote.paging.MoviePageKeyedDataSource;
import com.cuonghuynh.myapplication.ui.movieslist.MoviesFilterType;
import com.cuonghuynh.myapplication.utils.AppExecutors;

/**
 * @author Yassin Ajdi.
 */
public class MoviesRemoteDataSource {

    private static final int PAGE_SIZE = 20;

    private final AppExecutors mExecutors;

    private static volatile MoviesRemoteDataSource sInstance;

    private final MovieService mMovieService;

    private MoviesRemoteDataSource(MovieService movieService,
                                   AppExecutors executors) {
        mMovieService = movieService;
        mExecutors = executors;
    }

    public static MoviesRemoteDataSource getInstance(MovieService movieService,
                                                     AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppExecutors.class) {
                if (sInstance == null) {
                    sInstance = new MoviesRemoteDataSource(movieService, executors);
                }
            }
        }
        return sInstance;
    }

    public LiveData<ApiResponse<Movie>> loadMovie(final long movieId) {
        return mMovieService.getMovieDetails(movieId);
    }

    /**
     * Load movies for certain filter.
     */
    public RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy) {
        MovieDataSourceFactory sourceFactory =
                new MovieDataSourceFactory(mMovieService, mExecutors.networkIO(), sortBy);

        // paging configuration
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(PAGE_SIZE)
                .build();

        // Get the paged list
        LiveData<PagedList<Movie>> moviesPagedList = new LivePagedListBuilder<>(sourceFactory, config)
                .setFetchExecutor(mExecutors.networkIO())
                .build();

        LiveData<Resource> networkState = Transformations.switchMap(sourceFactory.sourceLiveData, new Function<MoviePageKeyedDataSource, LiveData<Resource>>() {
            @Override
            public LiveData<Resource> apply(MoviePageKeyedDataSource input) {
                return input.networkState;
            }
        });

        // Get pagedList and network errors exposed to the viewmodel
        return new RepoMoviesResult(
                moviesPagedList,
                networkState,
                sourceFactory.sourceLiveData
        );
    }
}
