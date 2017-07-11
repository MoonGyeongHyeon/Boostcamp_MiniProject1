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

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewspeedFragment extends Fragment {
    @BindView(R.id.newspeedRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.newspeedSwipeLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static NewspeedFragment newInstance() {
        return new NewspeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_newspeed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(manager);

        ArrayList<NewspeedItem> itemList = getItemList();

        NewspeedRecyclerViewAdapter adapter = new NewspeedRecyclerViewAdapter(itemList, getContext());
        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private ArrayList<NewspeedItem> getItemList() {
        ArrayList<NewspeedItem> itemList = new ArrayList<>();

        HeaderItem header = new HeaderItem(NewspeedRecyclerViewAdapter.TYPE_HEADER);
        itemList.add(header);

        ContentItem content = new ContentItem(NewspeedRecyclerViewAdapter.TYPE_CONTENT);
        content.setWriterImage(R.drawable.video_mug);
        content.setWriter("비디오머그 - VIDEO MUG");
        content.setTime("2시간전");
        content.setContents("[비디오 머그 라이브] 최순실 딸 정유라 강제 소환\n\n-> 고화질 감상 https://youtu.be/XjLDue4kpRk");
        content.setContentsImage(R.drawable.video_mug_content);
        content.setExpressCount("1만");
        content.setCommentCount("9,689개");
        content.setSendCount("397회");
        content.setHitCount("32만회");
        itemList.add(content);

        content = new ContentItem(NewspeedRecyclerViewAdapter.TYPE_CONTENT);
        content.setWriterImage(R.drawable.youtube);
        content.setWriter("유튜브 - YOUTUBE");
        content.setTime("3시간전");
        content.setContents("[YOUTUBE] 【분량체크!】 박준형 - 라스 나와서 졸아도 이정도ㅋㅋ 얼마나 뺌뺌 터졌게요?");
        content.setContentsImage(R.drawable.youtube_content);
        content.setExpressCount("3만");
        content.setCommentCount("14,221개");
        content.setSendCount("831회");
        content.setHitCount("87만회");
        itemList.add(content);

        content = new ContentItem(NewspeedRecyclerViewAdapter.TYPE_CONTENT);
        content.setWriterImage(R.drawable.sbs);
        content.setWriter("스브스타 - SBS");
        content.setTime("6시간전");
        content.setContents("[스브스타] 송중기-송혜교 결혼이 중견기업 합병이라 하는 이유");
        content.setContentsImage(R.drawable.sbs_content);
        content.setExpressCount("8천");
        content.setCommentCount("5,219개");
        content.setSendCount("184회");
        content.setHitCount("75만회");
        itemList.add(content);

        return itemList;
    }
}
