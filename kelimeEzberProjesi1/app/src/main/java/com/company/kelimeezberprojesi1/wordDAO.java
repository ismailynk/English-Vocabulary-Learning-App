package com.company.kelimeezberprojesi1;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface wordDAO {
    @Insert
    void Insert(sqlwords word);

    @Query("SELECT* from words ORDER BY id ASC")
    LiveData< List<sqlwords>> getAllwords();
}
