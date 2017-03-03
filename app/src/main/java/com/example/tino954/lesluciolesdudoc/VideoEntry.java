package com.example.tino954.lesluciolesdudoc;

/**
 * Created by tino954 on 03/03/2017.
 */
/**Video entry has title and an id */
public final class VideoEntry {
    private final String text;
    private final String videoId;

    public VideoEntry(String text, String videoId) {
        this.text = text;
        this.videoId = videoId;
    }

    public String getText() {
        return text;
    }

    public String getVideoId() {
        return videoId;
    }
}
