package com.example.practicafragment;



import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        PrimerFragment f1 = new PrimerFragment();
        SegundoFragment f2 = new SegundoFragment();
        TercerFragment f3 = new TercerFragment();

        switch(position) {
            case 0:
                return f1;
            case 1:
                return f2;
            case 2:
                return f3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  "fRAGMENT" + position;
    }
}
