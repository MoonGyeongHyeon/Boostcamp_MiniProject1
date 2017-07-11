package com.example.moon.firstproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainToolbar)
    Toolbar mToolbar;
    @BindView(R.id.homeTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.homeViewPager)
    ViewPager mViewPager;

    @OnClick(R.id.menuDirectImageButton)
    void onMenuDirectEvent() {
        Toast.makeText(this, "Direct!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.menuPostImageButton)
    void onMenuPostEvent() {
        Toast.makeText(this, "Post!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        ButterKnife.bind(this);

        initToolbar();
        initTabLayout();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("MiniProject1");
    }

    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.icon1_selector));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.icon2_selector));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.icon3_selector));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.icon4_selector));

        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(homeViewPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
