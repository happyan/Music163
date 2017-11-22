package com.hap.music163demo.ui.fragments.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hap.music163demo.R;
import com.hap.music163demo.adapter.HomeFragmentPageAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabGank;
    private ViewPager vpGank;
    private ArrayList<String> mTitleList = new ArrayList<>(4);
    private ArrayList<Fragment> mFragments = new ArrayList<>(4);
    private HomeFragmentPageAdapter myAdapter;

    private void assignViews(View view) {
        tabGank = (TabLayout) view.findViewById(R.id.tab_gank);
        vpGank = (ViewPager) view.findViewById(R.id.vp_gank);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        assignViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentList();
        myAdapter = new HomeFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vpGank.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpGank);
    }


    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("知乎日报");
        mTitleList.add("头条新闻");
        mTitleList.add("排行榜");
        mTitleList.add("最新电影");
        mFragments.add(new ZhiHuHomeFragment());
        mFragments.add(new TopNewsFragment());
        mFragments.add(new DouBanMovieTopFragment());
        mFragments.add(new DouBanMovieLatestFragment());
    }
}
