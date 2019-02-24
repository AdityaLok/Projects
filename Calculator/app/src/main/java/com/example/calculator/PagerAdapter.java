package com.example.calculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int noTabs;

    public PagerAdapter(FragmentManager fm, Integer noTabs) {
        super(fm);
        this.noTabs = noTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GeneralCalculator tab1 = new GeneralCalculator();
                return tab1;

            case 1:
                ScientificCalculator tab2 = new ScientificCalculator();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noTabs;
    }
}
