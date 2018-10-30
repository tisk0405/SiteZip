package com.example.kccistc.sitezip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kccistc.sitezip.R;
import com.example.kccistc.sitezip.Youtube;
import com.example.kccistc.sitezip.models.YoutubeDTO;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class YoutubeAdapter extends BaseAdapter {
    ArrayList<YoutubeDTO> list;
    Context context;
    int layout;


    LayoutInflater inflater;

    public YoutubeAdapter(Context context, int layout, ArrayList<YoutubeDTO> list) {
        this.list = list;
        this.context = context;
        this.layout = layout;
        inflater = LayoutInflater.from(context);

        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int i, View view, ViewGroup vg) {
//        if(view == null)
//            view = inflater.inflate(layout,null);
//
//        YoutubeDTO item = list.get(i);
//
//        ImageView thumb = view.findViewById(R.id.youtube_img);
//        TextView title = view.findViewById(R.id.youtube_title);
//        TextView published = view.findViewById(R.id.youtube_published);

        View v = view;

        if(v == null)
            v = inflater.inflate(R.layout.youtube_item2,vg,false);

        YoutubeDTO item = list.get(i);

        ImageView thumb = v.findViewById(R.id.youtube_img2);
        TextView title = v.findViewById(R.id.youtube_title2);
        TextView published = v.findViewById(R.id.youtube_published2);

        title.setSelected(true);

        Glide.with(context).load(item.getThumbnail()).into(thumb);
        title.setText(item.getTitle());
        published.setText(item.getPublishedAt());



        return v;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
