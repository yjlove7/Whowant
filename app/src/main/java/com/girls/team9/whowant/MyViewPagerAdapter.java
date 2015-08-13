package com.girls.team9.whowant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hyemi on 2015-08-13.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = new Fragment[2];

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new BestListFragment();
        fragments[1] = new CategoryFragment();

    }//MyViewPagerAdapter

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "추천";
            case 1:
                return "카테고리";
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

}//class
