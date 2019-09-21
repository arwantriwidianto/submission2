package com.example.filmapp.movies;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelMovies implements Parcelable {

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

    public ParcelMovies() {
    }

    protected ParcelMovies(Parcel in) {
        this.Title = in.readString();
        this.Desc = in.readString();
        this.Image = in.readInt();
        this.Banner = in.readInt();
    }

    public static final Creator<ParcelMovies> CREATOR = new Creator<ParcelMovies>() {
        @Override
        public ParcelMovies createFromParcel(Parcel source) {
            return new ParcelMovies(source);
        }

        @Override
        public ParcelMovies[] newArray(int size) {
            return new ParcelMovies[size];
        }
    };
}
