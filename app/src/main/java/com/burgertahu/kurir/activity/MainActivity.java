package com.burgertahu.kurir.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.burgertahu.kurir.R;
import com.burgertahu.kurir.fragment.Beranda;
import com.burgertahu.kurir.fragment.Pengaturan;
import com.burgertahu.kurir.fragment.Proses;
import com.burgertahu.kurir.fragment.Riwayat;
import com.burgertahu.kurir.fragment.Selesai;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    public TabLayout tabSecond;
    private ViewPager viewPager;
    private TextView tabOne,tabTwo,tabThree;
    private String[] tabs = { String.valueOf(R.string.tabBeranda) ,
            String.valueOf(R.string.tabRiwayat) , String.valueOf(R.string.tabPengaturan)};

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

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position)
                {
                    case 1:
                        tabSecond.setVisibility(View.VISIBLE);
                        break;

                    default:
                        tabSecond.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabSecond = (TabLayout) findViewById(R.id.tabsecond);
        tabSecond.setVisibility(View.GONE);

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.tabBeranda);
        tabOne.setTextColor(getApplicationContext().getResources().getColor(R.color.tabNotActive));
        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.tabRiwayat);
        tabTwo.setTextColor(getApplicationContext().getResources().getColor(R.color.tabNotActive));
        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.tabPengaturan);
        tabThree.setTextColor(getApplicationContext().getResources().getColor(R.color.tabNotActive));
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

        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home , 0, 0);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history, 0 ,0);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings, 0 ,0);

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                switch( tab.getPosition())
                {
                    case 0: setTextViewDrawableColor(tabOne  , R.color.tabActive); break;
                    case 1: setTextViewDrawableColor(tabTwo , R.color.tabActive); break;
                    case 2: setTextViewDrawableColor(tabThree , R.color.tabActive); break;
                    default: setTextViewDrawableColor(tabOne , R.color.tabActive); break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                switch( tab.getPosition())
                {
                    case 0: setTextViewDrawableColor(tabOne  , R.color.tabNotActive); break;
                    case 1: setTextViewDrawableColor(tabTwo , R.color.tabNotActive); break;
                    case 2: setTextViewDrawableColor(tabThree , R.color.tabNotActive); break;
                    default: setTextViewDrawableColor(tabOne , R.color.tabNotActive); break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);
            }
        });

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
        adapter.addFrag(new Riwayat(tabSecond), tabs[1]);
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
            switch (position)
            {
                case 0:
                    Beranda beranda = new Beranda();
                    return beranda;
                case 1:
                    Riwayat riwayat = new Riwayat(tabSecond);
                    return riwayat;
                case 2:
                    Pengaturan pengaturan = new Pengaturan();
                    return pengaturan;
//                case 3:
//                    Proses progress = new Proses();
//                    return progress;
//                case 4:
//                    Selesai done = new Selesai();
//                    return done;
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

    @TargetApi(Build.VERSION_CODES.M)
    public void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getColor(color), PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
