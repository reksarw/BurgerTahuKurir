package com.burgertahu.kurir.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Riwayat extends Fragment{

    private String[] tabs = { String.valueOf(R.string.tabProses) , String.valueOf(R.string.tabCompleted)};
    private ViewPager viewPager;
    private TabLayout tab;
    private TextView tabOne,tabTwo;

    public Riwayat(TabLayout tabLayout) {
        // Required empty public constructor
//        tab = tabLayout;
        this.tab = tabLayout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.halaman_riwayat, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpagerhistory);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        setupViewPager(viewPager);

        tab.setupWithViewPager(viewPager);

        tabOne = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.tabProses);
        tabOne.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabActive));
        tabTwo = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_tab, null);
        tabTwo.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabNotActive));
        tabTwo.setText(R.string.tabCompleted);
        tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                switch( tab.getPosition())
                {
                    case 0: tabOne.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabActive)); break;
                    case 1: tabTwo.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabActive)); break;
                    default: tabOne.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabActive)); break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                switch( tab.getPosition())
                {
                    case 0: tabOne.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabNotActive)); break;
                    case 1: tabTwo.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabNotActive)); break;
                    default: tabOne.setTextColor(getActivity().getApplicationContext().getResources().getColor(R.color.tabNotActive)); break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tab.getTabAt(0).setCustomView(tabOne);
        tab.getTabAt(1).setCustomView(tabTwo);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new Proses(), tabs[0]);
        adapter.addFrag(new Selesai(), tabs[1]);
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    Proses progress = new Proses();
                    return progress;
                case 1:
                    Selesai done = new Selesai();
                    return done;
                default:
                    return null;
            }

//            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return tabs[0];
                case 1:
                    return tabs[1];
            }

            return null;
//            return mFragmentTitleList.get(position);
        }
    }
}