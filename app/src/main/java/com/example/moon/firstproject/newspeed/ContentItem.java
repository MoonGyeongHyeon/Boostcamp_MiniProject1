package com.example.moon.firstproject.newspeed;

public class ContentItem extends NewspeedItem {
    private int mWriterImage;
    private String mWriter;
    private String mTime;
    private String mContents;
    private int mContentsImage;
    private String mExpressCount;
    private String mCommentCount;
    private String mSendCount;
    private String mHitCount;

    public ContentItem(int mViewType) {
        super(mViewType);
    }

    public int getWriterImage() {
        return mWriterImage;
    }

    public void setWriterImage(int mWriterImage) {
        this.mWriterImage = mWriterImage;
    }

    public String getWriter() {
        return mWriter;
    }

    public void setWriter(String mWriter) {
        this.mWriter = mWriter;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getContents() {
        return mContents;
    }

    public void setContents(String mContents) {
        this.mContents = mContents;
    }

    public int getContentsImage() {
        return mContentsImage;
    }

    public void setContentsImage(int mContentsImage) {
        this.mContentsImage = mContentsImage;
    }

    public String getExpressCount() {
        return mExpressCount;
    }

    public void setExpressCount(String mExpressCount) {
        this.mExpressCount = mExpressCount;
    }

    public String getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(String mCommentCount) {
        this.mCommentCount = mCommentCount;
    }

    public String getSendCount() {
        return mSendCount;
    }

    public void setSendCount(String mSendCount) {
        this.mSendCount = mSendCount;
    }

    public String getHitCount() {
        return mHitCount;
    }

    public void setHitCount(String mHitCount) {
        this.mHitCount = mHitCount;
    }
}
