package com.example.kccistc.sitezip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.kccistc.sitezip.adapter.AutoScrollAdapter;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout excercise_id, fashion_id, study_id, etc_id,
            music_id, photo_id, youtube_id;
    private AutoScrollViewPager autoViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        excercise_id = findViewById(R.id.excercise_id);
        fashion_id = findViewById(R.id.fashion_id);
        study_id = findViewById(R.id.study_id);
        etc_id = findViewById(R.id.etc_id);
        music_id = findViewById(R.id.music_id);
        photo_id = findViewById(R.id.photo_id);
        youtube_id = findViewById(R.id.youtube_id);

        excercise_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Excercise.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        fashion_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fashion.class);
                startActivity(intent);
            }
        });

        study_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Study.class);
                startActivity(intent);
            }
        });

        etc_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Etc.class);
                startActivity(intent);
            }
        });

        music_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Music.class);
                startActivity(intent);
            }
        });

        photo_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Photo.class);
                startActivity(intent);
            }
        });

        youtube_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Youtube.class);
                startActivity(intent);
            }
        });

        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add("https://images.unsplash.com/photo-1526506118085-60ce8714f8c5?ixlib=rb-0.3.5&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;s=34ca004a9cd0ce1144e94460a9f5e79b&amp;auto=format&amp;fit=crop&amp;w=334&amp;q=80 334w");
        data.add("https://images.unsplash.com/photo-1514866747592-c2d279258a78?ixlib=rb-0.3.5&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;s=35bb216e4f81c3bde24544b5630f5bd6&amp;auto=format&amp;fit=crop&amp;w=334&amp;q=80%20334w");
        data.add("https://images.unsplash.com/photo-1513127793999-24739949bdba?ixlib=rb-0.3.5&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;s=6d2b054f9ea91b55e655b9ca80c53c56&amp;auto=format&amp;fit=crop&amp;w=332&amp;q=80 332w");
        data.add("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-0.3.5&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;s=f9f0fdc18a215ec725f8ca61dc6fcbdf&amp;auto=format&amp;fit=crop&amp;w=332&amp;q=80 332w");
        data.add("https://images.unsplash.com/photo-1475274226786-e636f48a5645?ixlib=rb-0.3.5&amp;s=fd89560c7a987572f8c74ebfbf415416&amp;auto=format&amp;fit=crop&amp;w=332&amp;q=80 332w");


        autoViewPager = findViewById(R.id.autoViewpager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(4000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto S
    }
}
