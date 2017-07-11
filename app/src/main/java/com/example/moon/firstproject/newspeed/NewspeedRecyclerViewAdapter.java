package com.example.moon.firstproject.newspeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.firstproject.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewspeedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<NewspeedItem> mItemList;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_CONTENT = 1;
    private Context mContext;

    public NewspeedRecyclerViewAdapter(ArrayList<NewspeedItem> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("Test", "onCreateViewHolder viewType: " + String.valueOf(viewType));

        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_newspeed_header, parent, false);

            return new HeaderViewHolder(v);
        } else if (viewType == TYPE_CONTENT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_newspeed_content, parent, false);

            return new ItemViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderBinder) holder).bindItem();
    }

    @Override
    public int getItemViewType(int position) {
        return mItemList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    interface ViewHolderBinder {
        void bindItem();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
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

        @Override
        public void bindItem() {
            // Empty.
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder {
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

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.newspeedLikeLayout)
        void onLikeEvent(){
            Toast.makeText(mContext, "Like position " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedCommentLayout)
        void onCommentEvent(){
            Toast.makeText(mContext, "Comment position " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.newspeedSendLayout)
        void onSendEvent(){
            Toast.makeText(mContext, "Send position " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void bindItem() {
            ContentItem content = (ContentItem) mItemList.get(getAdapterPosition());

            mWriterImage.setImageResource(content.getWriterImage());
            mWriter.setText(content.getWriter() + "님이 방송을 종료했습니다.");
            mTime.setText(content.getTime());
            mContents.setText(content.getContents());
            if (content.getContentsImage() != 0) {
                mContentsImage.setImageResource(content.getContentsImage());
            } else {
                mContentsImage.setVisibility(View.GONE);
            }
            mExpressCount.setText(content.getExpressCount());
            mCommentCount.setText("댓글 " + content.getCommentCount());
            mSendCount.setText("공유 " + content.getSendCount());
            mHitCount.setText("조회 " + content.getHitCount());
        }
    }
}
