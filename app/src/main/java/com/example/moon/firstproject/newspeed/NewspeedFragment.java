package com.example.moon.firstproject.newspeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moon.firstproject.R;

import java.util.ArrayList;

public class NewspeedFragment extends Fragment {
    private ArrayList<Content> mItemlist;

    public static NewspeedFragment newInstance() {
        return new NewspeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.f_newspeed, container, false);

        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.newspeedRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(layout.getContext());
        recyclerView.setLayoutManager(manager);

        initItem();

        ContentRecyclerViewAdapter adapter = new ContentRecyclerViewAdapter(mItemlist, getContext());
        recyclerView.setAdapter(adapter);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) layout.findViewById(R.id.newspeedSwipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return layout;
    }

    void initItem() {
        mItemlist = new ArrayList<>();

        Content content = new Content();
        content.setmWriterImage(R.drawable.video_mug);
        content.setmWriter("비디오머그 - VIDEO MUG");
        content.setmTime("2시간전");
        content.setmContents("[비디오 머그 라이브] 최순실 딸 정유라 강제 소환\n\n-> 고화질 감상 https://youtu.be/XjLDue4kpRk");
        content.setmContentsImage(R.drawable.video_mug_content);
        content.setmExpressCount("1만");
        content.setmCommentCount("9,689개");
        content.setmSendCount("397회");
        content.setmHitCount("32만회");
        mItemlist.add(content);

        content = new Content();
        content.setmWriterImage(R.drawable.youtube);
        content.setmWriter("유튜브 - YOUTUBE");
        content.setmTime("3시간전");
        content.setmContents("[YOUTUBE] 【분량체크!】 박준형 - 라스 나와서 졸아도 이정도ㅋㅋ 얼마나 뺌뺌 터졌게요?");
        content.setmContentsImage(R.drawable.youtube_content);
        content.setmExpressCount("3만");
        content.setmCommentCount("14,221개");
        content.setmSendCount("831회");
        content.setmHitCount("87만회");
        mItemlist.add(content);

        content = new Content();
        content.setmWriterImage(R.drawable.sbs);
        content.setmWriter("스브스타 - SBS");
        content.setmTime("6시간전");
        content.setmContents("[스브스타] 송중기-송혜교 결혼이 중견기업 합병이라 하는 이유");
        content.setmContentsImage(R.drawable.sbs_content);
        content.setmExpressCount("8천");
        content.setmCommentCount("5,219개");
        content.setmSendCount("184회");
        content.setmHitCount("75만회");
        mItemlist.add(content);
    }
}
