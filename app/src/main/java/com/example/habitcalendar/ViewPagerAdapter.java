package com.example.habitcalendar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.habitcalendar.ui.TodayFragment;
import com.example.habitcalendar.ui.StatisticsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new TodayFragment();
        } else {
            return new StatisticsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }
}

