package com.example.moon.firstproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.moon.firstproject.setting.SettingFragment;
import com.example.moon.firstproject.newspeed.NewspeedFragment;
import com.example.moon.firstproject.notice.NoticeFragment;
import com.example.moon.firstproject.friends.FriendsFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private int mPageCount;

    public TabAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                f = NewspeedFragment.newInstance();
                break;
            case 1:
                f = FriendsFragment.newInstance();
                break;
            case 2:
                f = NoticeFragment.newInstance();
                break;
            case 3:
                f = SettingFragment.newInstance();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return mPageCount;
    }


}
