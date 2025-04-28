package com.example.habitcalendar.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Habit.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {

    private static volatile HabitDatabase INSTANCE;

    public abstract HabitDao habitDao();

    public static HabitDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (HabitDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    HabitDatabase.class, "habit-db")
                            .allowMainThreadQueries() // ✅ okay for development only!
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
