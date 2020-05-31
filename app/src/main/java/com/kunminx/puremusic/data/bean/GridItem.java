package com.kunminx.puremusic.data.bean;

/**
 * Create by KunMinX at 2020/5/27
 */
public class GridItem {

    private String uuid;
    private String title;
    private int drawable;
    private String packageName;
    private String activityPath;

    public GridItem() {
    }

    public GridItem(String uuid, String title, int drawable, String packageName, String activityPath) {
        this.uuid = uuid;
        this.title = title;
        this.drawable = drawable;
        this.packageName = packageName;
        this.activityPath = activityPath;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }
}
