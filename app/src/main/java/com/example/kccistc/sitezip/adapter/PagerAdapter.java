package com.example.kccistc.sitezip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.kccistc.sitezip.fragment.ChanelFragment;
import com.example.kccistc.sitezip.fragment.LikeFragment;
import com.example.kccistc.sitezip.fragment.PlayListFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumofTabs;

    public PagerAdapter(FragmentManager fm, int mNumofTabs) {
        super(fm);
        this.mNumofTabs = mNumofTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                ChanelFragment tab1 = new ChanelFragment();
                return tab1;
            case 1:
                PlayListFragment tab2 = new PlayListFragment();
                return tab2;
            case 2:
                LikeFragment tab3 = new LikeFragment();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumofTabs;
    }
}
