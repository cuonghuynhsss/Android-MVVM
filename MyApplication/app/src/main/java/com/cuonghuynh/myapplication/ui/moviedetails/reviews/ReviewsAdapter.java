package com.cuonghuynh.myapplication.ui.moviedetails.reviews;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cuonghuynh.myapplication.data.local.model.Review;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/12/2018.
 */
public class ReviewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Review> reviewList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ReviewsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        ((ReviewsViewHolder) holder).bindTo(review);
    }

    @Override
    public int getItemCount() {
        return reviewList != null ? reviewList.size() : 0;
    }

    public void submitList(List<Review> reviews) {
        reviewList = reviews;
        notifyDataSetChanged();
    }
}

