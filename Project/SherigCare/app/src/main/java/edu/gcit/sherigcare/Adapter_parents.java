package edu.gcit.sherigcare;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Adapter_parents extends FragmentStatePagerAdapter {
    int numberOfTabs;

    public Adapter_parents(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ParentChat();
            case 1:
                return new ParentResult();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
