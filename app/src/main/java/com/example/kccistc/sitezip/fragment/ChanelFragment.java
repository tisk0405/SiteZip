package com.example.kccistc.sitezip.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kccistc.sitezip.R;


public class ChanelFragment extends Fragment {

//    private static String GOOGLE_YOUTUBE_API_KEY = "AIzaSyAiL-zs1TQFlMVXVg0LS4It2fejRDn29hE";
//    private static String CHANEL_ID = "UClyThsEAiGbNeDFH5mAyumw";
//    private static String CHANEL_GET_URL = "http://www.googleapis.com/youtube/v3/search?part=snippet&order=date&channelId="+CHANEL_ID+"&maxResults=20&key="+GOOGLE_YOUTUBE_API_KEY;

    public ChanelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chanel, container, false);
        return view;
    }

}
