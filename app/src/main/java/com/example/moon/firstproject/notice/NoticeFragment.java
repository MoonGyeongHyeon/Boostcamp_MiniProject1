package com.example.moon.firstproject.notice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moon.firstproject.R;

public class NoticeFragment extends Fragment {

    public static NoticeFragment newInstance() {
        return new NoticeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.f_notice, container, false);
        return layout;
    }
}
