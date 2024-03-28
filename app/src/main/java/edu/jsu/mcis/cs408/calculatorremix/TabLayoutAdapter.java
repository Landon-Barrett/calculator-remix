package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;

        if(position == 0) {

            fragment = new TipCalculatorLayoutFragment();

            Bundle args = new Bundle();
            args.putInt(TipCalculatorLayoutFragment.ARG_ID, position + 1);
            fragment.setArguments(args);
        }
        else if(position == 1){

            fragment = new TempConverterLayoutFragment();

            Bundle args = new Bundle();
            args.putInt(TipCalculatorLayoutFragment.ARG_ID, position + 1);
            fragment.setArguments(args);
        }
        else {

            fragment = new DistanceConverterLayoutFragment();

            Bundle args = new Bundle();
            args.putInt(TipCalculatorLayoutFragment.ARG_ID, position + 1);
            fragment.setArguments(args);
        }

        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}