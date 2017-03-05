package com.example.tino954.lesluciolesdudoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChooseVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_video);

        final Button bSeeUnratedMovies = (Button) findViewById(R.id.bSeeUnratedMovies);

        bSeeUnratedMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                JSONArray titles = jsonResponse.getJSONArray("title");
                                JSONArray links = jsonResponse.getJSONArray("link");
                                Intent videoListIntent = new Intent(ChooseVideoActivity.this, VideoListActivity.class);
                                videoListIntent.putExtra("titles", titles.toString());
                                videoListIntent.putExtra("links", links.toString());
                                ChooseVideoActivity.this.startActivity(videoListIntent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseVideoActivity.this);
                                builder.setMessage("Error while loading videos")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                VideoRequest videoRequest = new VideoRequest(responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChooseVideoActivity.this);
                queue.add(videoRequest);
            }
        });
    }
}
