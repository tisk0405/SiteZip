package com.example.kccistc.sitezip;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.kccistc.sitezip.R.id.excercise_title;

public class ExcerciseAdapter extends RecyclerView.Adapter<ExcerciseAdapter.ExcerciseViewHolder> {

    private Context mContext;
    private ArrayList<ExcerciseItem> mExcerciseItems;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public ExcerciseAdapter(Context context, ArrayList<ExcerciseItem> excerciseItems){
        mContext = context;
        mExcerciseItems = excerciseItems;
    }

    @NonNull
    @Override
    public ExcerciseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup,false );
        return new ExcerciseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExcerciseViewHolder holder, int position) {
        ExcerciseItem item = mExcerciseItems.get(position);

        String imgUrl = item.getImgUrl();
        String title = item.getTitle();
        String intro = item.getIntro();
        String profile = item.getImgprofile();

        holder.mTextTitle.setText(title);
        holder.mTextIntro.setText(intro);
        //holder.mProfileImageView.setImageResource(Integer.parseInt(profile));
        Picasso.with(mContext).load(imgUrl).fit().centerInside().into(holder.mImageView);
        Picasso.with(mContext).load(profile).fit().centerInside().into(holder.mProfileImageView);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ExcerciseAdapter.ExcerciseViewHolder holder, int position, @NonNull List<Object> payloads) {
//
//
//        super.onBindViewHolder(holder, position, payloads);
//    }

    @Override
    public int getItemCount() {
        return mExcerciseItems.size();
    }

    public class ExcerciseViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextTitle;
        public TextView mTextIntro;
        public ImageView mProfileImageView;

        public ExcerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.excercise_background);
            mTextTitle = itemView.findViewById(R.id.excercise_title);
            mTextIntro = itemView.findViewById(R.id.excercise_intro);
            mProfileImageView = itemView.findViewById(R.id.profile_img);
//            mProfileImageView.setBackground(new ShapeDrawable(new OvalShape()));
//            mProfileImageView.setClipToOutline(true);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
