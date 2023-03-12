package com.cuonghuynh.myapplication.ui.moviedetails.cast;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.cuonghuynh.myapplication.data.local.model.Cast;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/12/2018.
 */
public class CastBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Cast> items) {
        CastAdapter adapter = (CastAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
