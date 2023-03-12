package com.cuonghuynh.myapplication.data.local.model;

import androidx.room.TypeConverter;

import com.cuonghuynh.myapplication.data.local.model.Genre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * @author Yassin Ajdi
 * @since 11/20/2018.
 */
public class Converters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static String fromGenresList(List<Genre> genres) {
        return gson.toJson(genres);
    }

    @TypeConverter
    public static List<Genre> toGenresList(String genres) {
        if (genres == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Genre>>() {}.getType();

        return gson.fromJson(genres, listType);
    }
}
