package com.cjj.easyview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.cjj.easyview.fragment.ButtonFragment;
import com.cjj.easyview.fragment.CardFragment;
import com.cjj.easyview.fragment.ImageFragment;
import com.cjj.easyview.fragment.SampleFragment;

/**
 * Created by cjj on 2015/3/19.
 */
public class HomeViewpagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public  HomeViewpagerFragmentAdapter(android.support.v4.app.FragmentManager fragmentManager,String[] titles)
    {
        super(fragmentManager);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            // Open FragmentTab1.java
            case 0:
                return SampleFragment.newInstance(position);
            case 1:
                return ImageFragment.newInstance();
            case 2:
                return ButtonFragment.newInstance();
            case 3:
                return CardFragment.newInstance();
            case 4:
                return SampleFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles==null?0:titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
