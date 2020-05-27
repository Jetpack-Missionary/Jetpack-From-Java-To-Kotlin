package com.kunminx.puremusic.data.bean;

/**
 * Create by KunMinX at 2020/5/27
 */
public class GridItem {

    private String title;
    private int drawable;
    private String activityPath;

    public GridItem() {
    }

    public GridItem(String title, int drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    public GridItem(String title, int drawable, String activityPath) {
        this.title = title;
        this.drawable = drawable;
        this.activityPath = activityPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }
}
