package com.example.todofragments;

import java.util.Date;
import java.util.UUID;

public class Todo {
    // This is the Todo object that was referenced in the fragment class.
    // It is public, can be called by the fragment class

    //Values that will be called
    private UUID mId;
    private String mTitle;
    private String mDetail;
    private Date mDate;
    private boolean mIsComplete;

    public Todo() {
        // So we have learned the ID is actually just a randomised value
        // Date isn't initialised here
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public void setIsComplete(boolean todoIsComplete) {
        mIsComplete = todoIsComplete;
    }

    // Just returns whether is complete or not from the first method
    public boolean isIsComplete() {
        return mIsComplete;
    }

    // These methods are fairly self-explanatory, setters and getters

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDetail() {
        return mDetail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setId(UUID todoId) {
        mId = todoId;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }

    public void setDate(Date todoDate) {
        mDate = todoDate;
    }
}
