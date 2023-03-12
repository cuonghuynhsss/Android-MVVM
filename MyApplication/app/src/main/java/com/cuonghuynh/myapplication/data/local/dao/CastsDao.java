package com.cuonghuynh.myapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.cuonghuynh.myapplication.data.local.model.Cast;

import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/12/2018.
 */
@Dao
public interface CastsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCasts(List<Cast> castList);

}
