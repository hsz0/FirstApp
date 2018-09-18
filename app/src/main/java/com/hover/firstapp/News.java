package com.hover.firstapp;

/**
 * Created by hover on 2018/3/6.
 */

public class News {
    private String title;
    private String commentNum;
    private int imgRes;

    public News(String title, String commentNum, int imgRes) {
        this.title = title;
        this.commentNum = commentNum;
        this.imgRes = imgRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
