package com.example.tino954.lesluciolesdudoc;

/**
 * Created by tino954 on 03/03/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**Video entry has title and an id */
class VideoEntry implements Parcelable {
    private final String text;
    private final String videoId;

    public VideoEntry() {
        text = "";
        videoId = "";
    }

    public VideoEntry(String text, String videoId) {
        this.text = text;
        this.videoId = videoId;
    }

    protected VideoEntry(Parcel in) {
        text = in.readString();
        videoId = in.readString();
    }

    public static final Creator<VideoEntry> CREATOR = new Creator<VideoEntry>() {
        @Override
        public VideoEntry createFromParcel(Parcel in) {
            return new VideoEntry(in);
        }

        @Override
        public VideoEntry[] newArray(int size) {
            return new VideoEntry[size];
        }
    };

    String getText() {
        return text;
    }

    String getVideoId() {
        return videoId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(videoId);
    }
}
