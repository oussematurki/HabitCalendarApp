package com.example.habitcalendar.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habitcalendar.R;
import com.example.habitcalendar.data.Habit;
import com.example.habitcalendar.data.HabitDao;
import com.example.habitcalendar.data.HabitDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.navigation.fragment.NavHostFragment;


import java.util.List;

public class TodayFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);

        // Find the RecyclerView from layout
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHabits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        // ✅ Use your singleton HabitDatabase instance
//        HabitDao habitDao = HabitDatabase.getInstance(requireContext()).habitDao();
//
//        // 🧪 Add temporary test habits
//        if (habitDao.getAllHabits().isEmpty()) {
//            habitDao.insert(new Habit("Read Quran", "Spiritual", Habit.HabitStatus.WAITING));
//            habitDao.insert(new Habit("Workout", "Health", Habit.HabitStatus.WAITING));
//            habitDao.insert(new Habit("Study", "Productivity", Habit.HabitStatus.WAITING));
//
//        }


//        // ⚠️ TEMP: Use allowMainThreadQueries() for testing; later switch to background thread
//        List<Habit> habits = habitDao.getAllHabits();

//        // ✅ Pass the DAO to the adapter so it can update Room when status changes
//        HabitAdapter adapter = new HabitAdapter(habits, habitDao);
//        recyclerView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = view.findViewById(R.id.fabAddHabit);
        fab.setOnClickListener(v -> {
            NavHostFragment.findNavController(TodayFragment.this)
                    .navigate(R.id.action_todayFragment_to_addHabitFragment);
        });
    }

}
