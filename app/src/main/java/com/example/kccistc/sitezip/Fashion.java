package com.example.kccistc.sitezip;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fashion extends AppCompatActivity implements ExcerciseAdapter.OnItemClickListener{

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "title";
    public static final String EXTRA_LIKES = "intro";

    private RecyclerView recyclerView;
    private ExcerciseAdapter excerciseAdapter;
    private ArrayList<ExcerciseItem> excerciseItems;
    private RequestQueue requestQueue;
    boolean toast = false;  // 토스트 메세지를 띄우기위한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //recyclerView.setAdapter(excerciseAdapter);

        excerciseItems = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        pareJSON();
    }

    private void pareJSON() {
        String url = "http://www.tisk0405.com/usefulsite/";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("fashion");
                            Log.e("JSONARRAYFASION", jsonArray.toString());

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject excercise = jsonArray.getJSONObject(i);

                                String title = excercise.getString("text");
                                String img = excercise.getString("img");
                                String intro = excercise.getString("intro");
                                String profile = excercise.getString("profile");
                                String url = excercise.getString("url");
                                Log.e("fahsion", "fashoin");
                                excerciseItems.add(new ExcerciseItem(img, title, intro, profile,url));
                            }

                            excerciseAdapter = new ExcerciseAdapter(Fashion.this, excerciseItems);
                            recyclerView.setAdapter(excerciseAdapter);
                            excerciseAdapter.setOnItemClickListener(Fashion.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {

            if (toast != true) {
                Toast.makeText(getApplicationContext(), "한번더 클릭하면 사이트로 이동합니다", Toast.LENGTH_LONG).show();
                toast = true;
            } else if (toast != false) {
                ExcerciseItem clik = excerciseItems.get(position);
                String url = clik.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                toast = false;
            }
        }


//    @Override
//    public void onItemClick(int position){
//        In
//    }
}
