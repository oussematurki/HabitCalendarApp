package com.example.habitcalendar.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habitcalendar.R;
import com.example.habitcalendar.data.Habit;
import com.example.habitcalendar.data.HabitDao;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {

    private List<Habit> habitList;
    private HabitDao habitDao;

    public HabitAdapter(List<Habit> habitList, HabitDao habitDao) {
        this.habitList = habitList;
        this.habitDao = this.habitDao;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_item, parent, false);
        return new HabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        Habit habit = habitList.get(position);

        holder.name.setText(habit.name);
        holder.category.setText(habit.category);

        updateIcon(holder.stateIcon, habit.status);

        holder.stateIcon.setOnClickListener(v -> {
            // Toggle through states
            switch (habit.status) {
                case WAITING:
                    habit.status = Habit.HabitStatus.DONE;
                    break;
                case DONE:
                    habit.status = Habit.HabitStatus.MISSED;
                    break;
                case MISSED:
                    habit.status = Habit.HabitStatus.WAITING;
                    break;
            }

            updateIcon(holder.stateIcon, habit.status);

            new Thread(() -> {
                habitDao.updateHabit(habit);
            }).start();

        });
    }

    // Update icon based on status
    private void updateIcon(ImageView view, Habit.HabitStatus status) {
        switch (status) {
            case WAITING:
                view.setImageResource(R.drawable.ic_waiting);
                break;
            case DONE:
                view.setImageResource(R.drawable.ic_check);
                break;
            case MISSED:
                view.setImageResource(R.drawable.ic_miss);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView name, category;
        ImageView stateIcon;

        public HabitViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvHabitName);
            category = itemView.findViewById(R.id.tvHabitCategory);
            stateIcon = itemView.findViewById(R.id.ivHabitState);
        }
    }
}
