package ciklum.umair.wikia.networkmanager;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

import ciklum.umair.wikia.interfaces.ResponseListener;
import ciklum.umair.wikia.models.WikiItem;
import ciklum.umair.wikia.models.WikisResponse;

/**
 * Created by umair1 on 10/13/15.
 */
public class NetworkManager {

    private static String baseUrl = "http://www.wikia.com/wikia.php?controller=WikisApi";

    private Context context;
    private ResponseListener responseListener;

    public NetworkManager(Context currentContext, ResponseListener listener) {
        this.context = currentContext;
        this.responseListener = listener;
    }

    public void getWikia(Integer pageNumber) {

        String requestBody = this.baseUrl+"&method=getList&limit=25&batch="+pageNumber+"hub=Gaming&lang=en";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, requestBody, "", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                WikisResponse wikisResponse = gson.fromJson(response.toString(), WikisResponse.class);
                responseListener.onWikiResponse(wikisResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error:", error.getLocalizedMessage().toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this.context);
        queue.add(jsonObjectRequest);
        queue.start();
    }

    public void getWikiDetail(final Integer id) {
        String requestBody = this.baseUrl+"&method=getDetails&ids="+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, requestBody, "", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject jsonObject = response.optJSONObject("items");
                jsonObject = jsonObject.optJSONObject(Integer.toString(id));
                Gson gson = new Gson();
                WikiItem wikiItem = gson.fromJson(jsonObject.toString(), WikiItem.class);
                WikisResponse wikisResponse = new WikisResponse();
                ArrayList<WikiItem> items = new ArrayList<WikiItem>();
                items.add(wikiItem);
                wikisResponse.setItems(items);
                responseListener.onWikiResponse(wikisResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error:", error.getLocalizedMessage().toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this.context);
        queue.add(jsonObjectRequest);
        queue.start();
    }
}
