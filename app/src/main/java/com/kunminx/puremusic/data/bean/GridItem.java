package com.kunminx.puremusic.data.bean;

/**
 * Create by KunMinX at 2020/5/27
 */
public class GridItem {

    private String title;
    private int drawable;
    private String packageName;
    private String activityName;

    public GridItem() {
    }

    public GridItem(String title, int drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    public GridItem(String title, int drawable, String packageName, String activityName) {
        this.title = title;
        this.drawable = drawable;
        this.packageName = packageName;
        this.activityName = activityName;
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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
