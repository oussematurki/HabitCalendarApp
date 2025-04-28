package com.example.habitcalendar.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.habitcalendar.data.Habit; // Make sure this path matches your file
@Dao
public interface HabitDao {
    @Insert
    void insert(Habit habit);

    @Query("SELECT * FROM habits")
    List<Habit> getAllHabits();

    @Delete
    void delete(Habit habit);

    @Update
    void updateHabit(Habit habit);

}
