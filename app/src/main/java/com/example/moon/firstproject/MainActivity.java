package com.example.moon.firstproject;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainToolbar)
    Toolbar mToolbar;
    @BindView(R.id.homeTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.homeViewPager)
    ViewPager mViewPager;

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

        mToolbar.setNavigationIcon(R.drawable.direct);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "direct!", Toast.LENGTH_SHORT).show();
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(MainActivity.this, "Search!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_post:
                Toast.makeText(MainActivity.this, "Post!", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
