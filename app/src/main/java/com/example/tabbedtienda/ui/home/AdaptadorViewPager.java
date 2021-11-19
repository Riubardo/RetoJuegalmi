package com.example.tabbedtienda.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdaptadorViewPager extends FragmentPagerAdapter {
    private int NUM_TABS = 3;


    public AdaptadorViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new VideojuegosFragment();
        }else if(position ==1){
            return new ConsolasFragment();
        }else{
            return new DispositivosFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "Videojuegos";
            case 1:return "Consolas";
            case 2:return "Telefonia";
            default:return null;
        }
    }


    @Override
    public int getCount() {
        return NUM_TABS;
    }
}