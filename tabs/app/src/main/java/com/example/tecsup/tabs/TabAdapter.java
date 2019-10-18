package com.example.tecsup.tabs;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableStringBuilder;

public class TabAdapter extends FragmentPagerAdapter {
    int cant_tab;

    public TabAdapter(FragmentManager fm, int cant_tab) {
        super(fm);
        this.cant_tab = cant_tab;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return  new CategoriasFragment();
        }else{
            return  new ProveedoresFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Pagina " + position;

    }
}
