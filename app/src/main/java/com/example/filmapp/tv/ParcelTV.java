package com.example.filmapp.tv;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelTV implements Parcelable {

    private String Title;
    private String Desc;
    private int Image;
    private int Banner;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getBanner() {
        return Banner;
    }

    public void setBanner(int banner) {
        Banner = banner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Title);
        dest.writeString(this.Desc);
        dest.writeInt(this.Image);
        dest.writeInt(this.Banner);
    }

    public ParcelTV() {
    }

    protected ParcelTV(Parcel in) {
        this.Title = in.readString();
        this.Desc = in.readString();
        this.Image = in.readInt();
        this.Banner = in.readInt();
    }

    public static final Creator<ParcelTV> CREATOR = new Creator<ParcelTV>() {
        @Override
        public ParcelTV createFromParcel(Parcel source) {
            return new ParcelTV(source);
        }

        @Override
        public ParcelTV[] newArray(int size) {
            return new ParcelTV[size];
        }
    };
}
