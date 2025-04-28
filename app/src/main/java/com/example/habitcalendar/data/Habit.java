package com.example.habitcalendar.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habits")
public class Habit {

    public Habit(String name, String category, HabitStatus status) {
        this.name = name;
        this.category = category;
        this.status = status;
    }
    public enum HabitStatus {
        WAITING,
        DONE,
        MISSED
    }


    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String category;
    public HabitStatus status = HabitStatus.WAITING;// checked / missed / waiting

    // Constructor, getters, setters (optional)

}
