package com.cuonghuynh.myapplication.data.local.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

import com.cuonghuynh.myapplication.data.local.model.Movie;
import com.cuonghuynh.myapplication.data.remote.paging.MoviePageKeyedDataSource;

/**
 * @author Yassin Ajdi.
 */
public class RepoMoviesResult {
    public LiveData<PagedList<Movie>> data;
    public LiveData<Resource> resource;
    public MutableLiveData<MoviePageKeyedDataSource> sourceLiveData;

    public RepoMoviesResult(LiveData<PagedList<Movie>> data,
                            LiveData<Resource> resource,
                            MutableLiveData<MoviePageKeyedDataSource> sourceLiveData) {
        this.data = data;
        this.resource = resource;
        this.sourceLiveData = sourceLiveData;
    }
}
