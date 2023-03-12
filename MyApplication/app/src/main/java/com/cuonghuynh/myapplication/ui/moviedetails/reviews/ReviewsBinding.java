package com.cuonghuynh.myapplication.ui.moviedetails.reviews;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.cuonghuynh.myapplication.data.local.model.Review;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/12/2018.
 */
public class ReviewsBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Review> items) {
        ReviewsAdapter adapter = (ReviewsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
