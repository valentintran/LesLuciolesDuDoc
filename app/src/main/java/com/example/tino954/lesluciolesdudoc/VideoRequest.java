package com.example.tino954.lesluciolesdudoc;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tino954 on 27/02/2017.
 */
public class VideoRequest extends StringRequest{
    private static final String VIDEO_REQUEST_URL = "http://www.lesluciolesdudoc.org/intranet/ressources/MobileApp/videoRequest.php";
    private Map<String, String> params;

    VideoRequest(Response.Listener<String> listener) {
        super(Request.Method.POST, VIDEO_REQUEST_URL, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
