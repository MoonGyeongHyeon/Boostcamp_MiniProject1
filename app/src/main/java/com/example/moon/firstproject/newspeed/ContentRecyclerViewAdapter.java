package com.example.moon.firstproject.newspeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.firstproject.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContentRecyclerViewAdapter extends RecyclerView.Adapter<ContentRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Content> mItemList;
    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;
    private Context mContext;

    public ContentRecyclerViewAdapter(ArrayList<Content> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("Test", "onCreateViewHolder viewType: " + String.valueOf(viewType));

        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_newspeed_header, parent, false);

            return new HeaderViewHolder(v, viewType);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_newspeed, parent, false);
            return new ItemViewHolder(v, viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("Test", "onBindViewHolder position: " + String.valueOf(position));
        if (holder.mViewType == TYPE_HEADER) {

        } else if (holder.mViewType == TYPE_ITEM) {
            ((ItemViewHolder) holder).setItem(position-1);
        }
    }

    @Override
    public int getItemViewType(int position) {
//        Log.d("Test", "getItemViewType position: " + String.valueOf(position));

        if (isHeader(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private boolean isHeader(int position) {
        return position == TYPE_HEADER;
    }

    @Override
    public int getItemCount() {
        return mItemList.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        int mViewType;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            mViewType = viewType;
        }
    }

    class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View itemView, int viewType) {
            super(itemView, viewType);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.newspeedCameraImageButton)
        void onCameraClickEvent() {
            Toast.makeText(mContext, "Camera!!", Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedMyStoryImageButton)
        void onStoryClickEvent() {
            Toast.makeText(mContext, "My Story!!", Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedProfileImageButton)
        void onProfileClickEvent() {
            Toast.makeText(mContext, "Profile!!", Toast.LENGTH_SHORT).show();
        }
    }

    class ItemViewHolder extends ViewHolder {
        @BindView(R.id.newspeedWriterImageView)
        ImageView mWriterImage;
        @BindView(R.id.newspeedWriterTextView)
        TextView mWriter;
        @BindView(R.id.newspeedTimeTextView)
        TextView mTime;
        @BindView(R.id.newspeedContentsTextView)
        TextView mContents;
        @BindView(R.id.newspeedContentsImageView)
        ImageView mContentsImage;
        @BindView(R.id.newspeedExpressCountTextView)
        TextView mExpressCount;
        @BindView(R.id.newspeedCommentCountTextView)
        TextView mCommentCount;
        @BindView(R.id.newspeedSendCountTextView)
        TextView mSendCount;
        @BindView(R.id.newspeedHitsCountTextView)
        TextView mHitCount;
        @BindView(R.id.newspeedLikeLayout)
        RelativeLayout mLikeLayout;
        @BindView(R.id.newspeedCommentLayout)
        RelativeLayout mCommentLayout;
        @BindView(R.id.newspeedSendLayout)
        RelativeLayout mSendLayout;
        private int position;

        public ItemViewHolder(View itemView, int viewType) {
            super(itemView, viewType);
            ButterKnife.bind(this, itemView);
        }

        public void setItem(int pos) {
            position = pos;
            Content content = mItemList.get(position);

            mWriterImage.setImageResource(content.getmWriterImage());
            mWriter.setText(content.getmWriter() + "님이 방송을 종료했습니다.");
            mTime.setText(content.getmTime());
            mContents.setText(content.getmContents());
            mContentsImage.setImageResource(content.getmContentsImage());
            mExpressCount.setText(content.getmExpressCount());
            mCommentCount.setText("댓글 " + content.getmCommentCount());
            mSendCount.setText("공유 " + content.getmSendCount());
            mHitCount.setText("조회 " + content.getmHitCount());
        }

        @OnClick(R.id.newspeedLikeLayout)
        void onLikeEvent(){
            Toast.makeText(mContext, "Like position " + String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedCommentLayout)
        void onCommentEvent(){
            Toast.makeText(mContext, "Comment position " + String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedSendLayout)
        void onSendEvent(){
            Toast.makeText(mContext, "Send position " + String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
    }

}
