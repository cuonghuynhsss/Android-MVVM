package com.cuonghuynh.myapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.cuonghuynh.myapplication.data.local.model.Trailer;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/11/2018.
 */
@Dao
public interface TrailersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTrailers(List<Trailer> trailers);

}
