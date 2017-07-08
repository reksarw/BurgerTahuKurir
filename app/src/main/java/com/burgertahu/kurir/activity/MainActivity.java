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
import com.burgertahu.kurir.fragment.OneFragment;
import com.burgertahu.kurir.fragment.ThreeFragment;
import com.burgertahu.kurir.fragment.TwoFragment;
import com.burgertahu.kurir.helper.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tabOne,tabTwo,tabThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetails();

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
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home , 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "menu 1");
        adapter.addFrag(new TwoFragment(), "menu 2");
        adapter.addFrag(new ThreeFragment(), "menu 3");
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
            return mFragmentList.get(position);
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
            return mFragmentTitleList.get(position);
        }
    }
}
