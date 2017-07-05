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

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        mToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(mToolbar);

//        mToolbar.setTitle("TestTest");
        mToolbar.setNavigationIcon(R.drawable.direct);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "direct!", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setTitle("test");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.homeTabLayout);

        initTabLayout(tabLayout);
    }

    void initTabLayout(TabLayout tabLayout) {
        tabLayout.setBackgroundColor(Color.parseColor("#ffffff"));

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon2_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon3_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon4_selector));

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        final ViewPager viewPager = (ViewPager) findViewById(R.id.homeViewPager);
        viewPager.setAdapter(tabAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
