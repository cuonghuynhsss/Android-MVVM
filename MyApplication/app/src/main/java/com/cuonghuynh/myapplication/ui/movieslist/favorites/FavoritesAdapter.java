package com.cuonghuynh.myapplication.ui.movieslist.favorites;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cuonghuynh.myapplication.data.local.model.Movie;
import com.cuonghuynh.myapplication.ui.movieslist.MovieViewHolder;

import java.util.List;

/**
 * @author Yassin Ajdi.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> mMoviesList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        com.cuonghuynh.myapplication.data.local.model.Movie movie = mMoviesList.get(position);
        ((MovieViewHolder) holder).bindTo(movie);
    }

    @Override
    public int getItemCount() {
        return mMoviesList != null ? mMoviesList.size() : 0;
    }

    public void submitList(List<Movie> movies) {
        mMoviesList = movies;
        notifyDataSetChanged();
    }
}
