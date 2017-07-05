package com.example.moon.firstproject.newspeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.firstproject.R;

import java.util.ArrayList;

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

            initImageButtons(v);

            return new ViewHolder(v, viewType);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_newspeed, parent, false);
            return new ViewHolder(v, viewType);
        }
        return null;
//        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
//        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("Test", "onBindViewHolder position: " + String.valueOf(position));
        if (holder.mViewType == TYPE_HEADER) {

        } else if (holder.mViewType == TYPE_ITEM) {
            final int pos = position-1;
            Content content = mItemList.get(pos);

            holder.mWriterImage.setImageResource(content.getmWriterImage());
            holder.mWriter.setText(content.getmWriter() + "님이 방송을 종료했습니다.");
            holder.mTime.setText(content.getmTime());
            holder.mContents.setText(content.getmContents());
            holder.mContentsImage.setImageResource(content.getmContentsImage());
            holder.mExpressCount.setText(content.getmExpressCount());
            holder.mCommentCount.setText("댓글 " + content.getmCommentCount());
            holder.mSendCount.setText("공유 " + content.getmSendCount());
            holder.mHitCount.setText("조회 " + content.getmHitCount());

            holder.mLikeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Like position " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                }
            });

            holder.mCommentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Comment position " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                }
            });

            holder.mSendLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Send position " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                }
            });
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

    private void initImageButtons(View v) {
        ImageButton cameraImageButton = (ImageButton) v.findViewById(R.id.newspeedCameraImageButton);
        cameraImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Camera!!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton myStoryImageButton = (ImageButton) v.findViewById(R.id.newspeedMyStoryImageButton);
        myStoryImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "My Story!!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton profileImageButton = (ImageButton) v.findViewById(R.id.newspeedProfileImageButton);
        profileImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Profile!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int mViewType;
        private ImageView mWriterImage;
        private TextView mWriter;
        private TextView mTime;
        private TextView mContents;
        private ImageView mContentsImage;
        private TextView mExpressCount;
        private TextView mCommentCount;
        private TextView mSendCount;
        private TextView mHitCount;
        private View mLikeLayout;
        private View mCommentLayout;
        private View mSendLayout;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            mViewType = viewType;

            Log.d("Test", "ViewHolder viewType: " + String.valueOf(viewType));

            if (viewType == TYPE_HEADER) {
            } else if (viewType == TYPE_ITEM) {
                mWriterImage = (ImageView) itemView.findViewById(R.id.newspeedWriterImageView);
                mWriter = (TextView) itemView.findViewById(R.id.newspeedWriterTextView);
                mTime = (TextView) itemView.findViewById(R.id.newspeedTimeTextView);
                mContents = (TextView) itemView.findViewById(R.id.newspeedContentsTextView);
                mContentsImage = (ImageView) itemView.findViewById(R.id.newspeedContentsImageView);
                mExpressCount = (TextView) itemView.findViewById(R.id.newspeedExpressCountTextView);
                mCommentCount = (TextView) itemView.findViewById(R.id.newspeedCommentCountTextView);
                mSendCount = (TextView) itemView.findViewById(R.id.newspeedSendCountTextView);
                mHitCount = (TextView) itemView.findViewById(R.id.newspeedHitsCountTextView);

                mLikeLayout = itemView.findViewById(R.id.newspeedLikeLayout);
                mCommentLayout = itemView.findViewById(R.id.newspeedCommentLayout);
                mSendLayout = itemView.findViewById(R.id.newspeedSendLayout);
            }
        }
    }

}
