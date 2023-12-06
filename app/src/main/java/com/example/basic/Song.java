package com.example.basic;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private String title;
    private String movie;
    private int photoResourceId;

    private String description;

    public Song(String title, String movie, int photoResourceId, String description) {
        this.title = title;
        this.movie = movie;
        this.photoResourceId = photoResourceId;
        this.description = description;
    }

    protected Song(Parcel in) {
        title = in.readString();
        movie = in.readString();
        photoResourceId = in.readInt();
        description = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getMovie() {
        return movie;
    }

    public int getPhotoResourceId() {
        return photoResourceId;
    }

    public String getDescription(){return description;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(movie);
        dest.writeInt(photoResourceId);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
