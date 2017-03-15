package com.example.tino954.lesluciolesdudoc;

import android.app.ListFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tino954 on 03/03/2017.
 */
/** This class is a list of fragments*/
public final class VideoListFragment extends ListFragment {
    /** The duration of the animation sliding up the video in portrait. */
    private static final int ANIMATION_DURATION_MILLIS = 300;

    private List<VideoEntry> VIDEO_LIST;
    /** We need the video list here that we got in VideoListActivity from parsing json array
     * got after the request to the DB*/

    private PageAdapter adapter;
    private View videoBox;

    public static VideoListFragment newInstance(ArrayList<VideoEntry> entries) {
        VideoListFragment fragment = new VideoListFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList("entries", entries);
        fragment.setArguments(arguments);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VIDEO_LIST = getArguments().getParcelableArrayList("entries");
        adapter = new PageAdapter(getActivity(), VIDEO_LIST);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        videoBox = getActivity().findViewById(R.id.video_box);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String videoId = VIDEO_LIST.get(position).getVideoId();

        VideoFragment videoFragment =
                (VideoFragment) getFragmentManager()
                        .findFragmentById(R.id.video_fragment_container);
        videoFragment.setVideoId(videoId);

        // The videoBox is INVISIBLE if no video was previously selected, so we need to show it now.
        if (videoBox.getVisibility() != View.VISIBLE) {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // Initially translate off the screen so that it can be animated in from below.
                videoBox.setTranslationY(videoBox.getHeight());
            }
            videoBox.setVisibility(View.VISIBLE);
        }

        // If the fragment is off the screen, we animate it in.
        if (videoBox.getTranslationY() > 0) {
            videoBox.animate().translationY(0).setDuration(ANIMATION_DURATION_MILLIS);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        adapter.releaseLoaders();
    }

    public void setLabelVisibility(boolean visible) {
        adapter.setLabelVisibility(visible);
    }

}
