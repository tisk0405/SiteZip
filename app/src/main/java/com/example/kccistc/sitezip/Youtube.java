package com.example.kccistc.sitezip;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.kccistc.sitezip.adapter.YoutubeAdapter;
import com.example.kccistc.sitezip.models.YoutubeDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Youtube extends AppCompatActivity {

    //private TabLayout tabLayout = null;
    //private ViewPager viewPager = null;
    ArrayList<YoutubeDTO> list = new ArrayList<>();
    boolean lastItemVisibleFlag = false;
    boolean isNetworking = false;
    String nextPageToken = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

//        tabLayout = findViewById(R.id.tab_layout);
//        viewPager = findViewById(R.id.viewpager);

        //setting the tab title
//        tabLayout.addTab(tabLayout.newTab().setText("Chanel"));
//        tabLayout.addTab(tabLayout.newTab().setText("PlayList"));
//        tabLayout.addTab(tabLayout.newTab().setText("Like"));

        //setup the viewpager
//        final PagerAdapter adapter = new com.example.kccistc.sitezip.adapter.PagerAdapter(getSupportFragmentManager(),
//                tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = Network.getData("https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=20&key=AIzaSyAiL-zs1TQFlMVXVg0LS4It2fejRDn29hE&q=웃긴&type=video");
                Log.e("result", result);

                try {
                    JSONObject obj = new JSONObject(result);

                    nextPageToken = obj.getString("nextPageToken");

                    JSONArray items = obj.getJSONArray("items");
                    for(int i =0; i< items.length(); i++){
                        JSONObject item = items.getJSONObject(i);
                        JSONObject id = item.getJSONObject("id");
                        String videoId = id.getString("videoId");

                        JSONObject snippet = item.getJSONObject("snippet");
                        String title = snippet.getString("title");
                        String published = snippet.getString("publishedAt");

                        JSONObject thumb = snippet.getJSONObject("thumbnails");
                        JSONObject high = thumb.getJSONObject("high");
                        String url = high.getString("url");

                        YoutubeDTO dto = new YoutubeDTO();
                        dto.setTitle(title);
                        dto.setVideoId(videoId);
                        dto.setPublishedAt(published);
                        dto.setThumbnail(url);

                        list.add(dto);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final YoutubeAdapter adapter = new YoutubeAdapter(Youtube.this, R.layout.youtube_item, list);

                        final ListView listView = findViewById(R.id.youtube_listview);
                        listView.setAdapter(adapter);

                        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged(AbsListView absListView, int i) {
                                if(i == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastItemVisibleFlag && !isNetworking) {
                                    //TODO 화면이 바닦에 닿을때 처리
                                    //
                                    isNetworking = true;
                                    getData();
                                    adapter.notifyDataSetChanged();
                                    Log.e("gdgd","scrollling!!!!!!!");

                                }

                            }

                            @Override
                            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                                 int visibleItemCount, int totalItemCount) {
                                if(totalItemCount == (visibleItemCount + firstVisibleItem)) {
                                    // 리스트뷰 마지막 요소까지 올라갔음
                                    lastItemVisibleFlag = true;
                                }
                            }
                        });

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                YoutubeDTO dto = list.get(i);
                                String videoId = dto.getVideoId();
                                Intent intent = new Intent(Youtube.this, PlayYoutube.class);
                                intent.putExtra("video", videoId);
                                startActivity(intent);
                            }
                        });

                    }
                });
            }
        }).start();
    }

    public void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = Network.getData("https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=20&key=AIzaSyAiL-zs1TQFlMVXVg0LS4It2fejRDn29hE&q=꿀잼&type=video&pageToken=" + nextPageToken);
                Log.e("result", result);

                try {
                    JSONObject obj = new JSONObject(result);

                    nextPageToken = obj.getString("nextPageToken");

                    JSONArray items = obj.getJSONArray("items");
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject item = items.getJSONObject(i);
                        JSONObject id = item.getJSONObject("id");
                        String videoId = id.getString("videoId");

                        JSONObject snippet = item.getJSONObject("snippet");
                        String title = snippet.getString("title");
                        String published = snippet.getString("publishedAt");

                        JSONObject thumb = snippet.getJSONObject("thumbnails");
                        JSONObject high = thumb.getJSONObject("high");
                        String url = high.getString("url");

                        YoutubeDTO dto = new YoutubeDTO();
                        dto.setTitle(title);
                        dto.setVideoId(videoId);
                        dto.setPublishedAt(published);
                        dto.setThumbnail(url);

                        list.add(dto);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                lastItemVisibleFlag = false;
                isNetworking = false;
            }
        }).start();
    }
}
