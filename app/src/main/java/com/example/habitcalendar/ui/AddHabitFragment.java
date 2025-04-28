package com.example.habitcalendar.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.habitcalendar.R;
import com.example.habitcalendar.data.Habit;
import com.example.habitcalendar.data.HabitDao;
import com.example.habitcalendar.data.HabitDatabase;
import com.example.habitcalendar.data.HabitStatus;

public class AddHabitFragment extends Fragment {

    private EditText editTextName, editTextCategory;
    private Button buttonSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_habit, container, false);

        editTextName = view.findViewById(R.id.editTextHabitName);
        editTextCategory = view.findViewById(R.id.editTextHabitCategory);
        buttonSave = view.findViewById(R.id.buttonSaveHabit);

        HabitDao habitDao = HabitDatabase.getInstance(requireContext()).habitDao();

        buttonSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String category = editTextCategory.getText().toString().trim();

            if (name.isEmpty() || category.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Habit newHabit = new Habit(name, category, Habit.HabitStatus.WAITING); // default WAITING status
            habitDao.insert(newHabit);

            Toast.makeText(getContext(), "Habit added!", Toast.LENGTH_SHORT).show();

            // Navigate back
            NavHostFragment.findNavController(AddHabitFragment.this).popBackStack();
        });

        return view;
    }
}
