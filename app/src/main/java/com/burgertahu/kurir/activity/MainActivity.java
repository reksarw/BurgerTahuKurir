package com.burgertahu.kurir.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.fragment.Beranda;
import com.burgertahu.kurir.fragment.Pengaturan;
import com.burgertahu.kurir.fragment.Riwayat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tabOne,tabTwo,tabThree;
    private String[] tabs = { String.valueOf(R.string.tabBeranda) , String.valueOf(R.string.tabRiwayat) , String.valueOf(R.string.tabPengaturan)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Font setting */
        String fontPath= "fonts/dancing_in_the_rainbow.ttf";
        Typeface type = Typeface.createFromAsset(getAssets(), fontPath);
        TextView txtHeader = (TextView) findViewById(R.id.txtBurgerTahu);
        txtHeader.setTypeface(type);
        /* Font setting */

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.tabBeranda);
        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.tabRiwayat);
        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.tabPengaturan);
        setTabLayout();
    }

    /**
     * Adding custom view to tab
     */
    private void setTabLayout() {
//        final int[] ICONS = new int[]{
//                R.drawable.ic_home,
//                R.drawable.ic_history,
//                R.drawable.ic_settings
//        };
//
//        for(int i =0; i < tabs.length; i ++)
//        {
//            tabLayout.getTabAt(i).setIcon(getResources().getDrawable(ICONS[i]));
//        }

        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home , 0, 0);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history, 0 ,0);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings, 0 ,0);
        tabLayout.getTabAt(0).setCustomView(tabOne);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Beranda(), tabs[0]);
        adapter.addFrag(new Riwayat(), tabs[1]);
        adapter.addFrag(new Pengaturan(), tabs[2]);
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
            // here
            switch (position)
            {
                case 0:
                    Beranda beranda = new Beranda();
                    return beranda;
                case 1:
                    Riwayat riwayat = new Riwayat();
                    return riwayat;
                case 2:
                    Pengaturan pengaturan = new Pengaturan();
                    return pengaturan;
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
                case 2:
                    return tabs[2];
            }

            return null;
//            return mFragmentTitleList.get(position);
        }
    }
}
