

package com.kunminx.jetpack_java.common_data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TODO：本示例专注于提供 Jetpack 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
 * kotlin 模块提供同样的场景和基于 Kotlin 的写法，可对照查阅。
 * 并且本项目的示例从 sample_01 到 sample_05 是循序渐进地 Jetpack 化，
 * 如看完对 Jetpack 高频核心组件 "为什么要用"、"为什么要这样用" 有了一丝丝好奇心，可前往《Jetpack MVVM 精讲》和《Jetpack MVVM 最佳实践》项目查阅深度解析。
 * <p>
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * <p>
 * Create by KunMinX at 2020/5/30
 */
public class Moment implements Parcelable {

    private String uuid;
    private String content;
    private String location;
    private String imgUrl;
    private String userName;
    private String userAvatar;

    public Moment() {
    }

    public Moment(String uuid, String content, String location, String imgUrl, String userName, String userAvatar) {
        this.uuid = uuid;
        this.content = content;
        this.location = location;
        this.imgUrl = imgUrl;
        this.userName = userName;
        this.userAvatar = userAvatar;
    }

    protected Moment(Parcel in) {
        uuid = in.readString();
        content = in.readString();
        location = in.readString();
        imgUrl = in.readString();
        userName = in.readString();
        userAvatar = in.readString();
    }

    public static final Creator<Moment> CREATOR = new Creator<Moment>() {
        @Override
        public Moment createFromParcel(Parcel in) {
            return new Moment(in);
        }

        @Override
        public Moment[] newArray(int size) {
            return new Moment[size];
        }
    };

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uuid);
        dest.writeString(content);
        dest.writeString(location);
        dest.writeString(imgUrl);
        dest.writeString(userName);
        dest.writeString(userAvatar);
    }
}
