package com.semicode.blooodbank.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerWithFragmentAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentsTitle = new ArrayList<>();

    public ViewPagerWithFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT );
        fragments = new ArrayList<>();
        fragmentsTitle = new ArrayList<>();


    }

    public void addPager(Fragment fragments, String fragmentTitle) {
        this.fragments.add(fragments);
        this.fragmentsTitle.add(fragmentTitle);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return fragments.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsTitle.get(position);
    }
}
