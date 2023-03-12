package com.cuonghuynh.myapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.cuonghuynh.myapplication.data.local.model.Review;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/13/2018.
 */
@Dao
public interface ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllReviews(List<Review> reviews);

}
