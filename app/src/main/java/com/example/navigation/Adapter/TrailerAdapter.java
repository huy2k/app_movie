package com.example.navigation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.navigation.R;
import com.example.navigation.model.TrailerData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerHolder> {

    private ArrayList<TrailerData> trailersList;
    private Context context;

    public TrailerAdapter(ArrayList<TrailerData> trailersList, Context context) {
        this.trailersList = trailersList;
        this.context = context;
    }

    @Override
    public TrailerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_row,parent,false);
        TrailerHolder trailerHolder = new TrailerHolder(item);
        return trailerHolder;
    }

    @Override
    public int getItemCount() {
        return trailersList.size();
    }

    @Override
    public void onBindViewHolder(TrailerHolder holder, int position) {

        final TrailerData trailer = trailersList.get(position);// trailer object
        context = holder.itemView.getContext();

        holder.videoName.setText(trailer.getVideoName());
        holder.videoLink.setText("https://www.youtube.com/watch?v="+trailer.getVideoLink());
        Picasso.with(context).load("http://img.youtube.com/vi/"+trailer.getVideoLink()+"/mqdefault.jpg").placeholder(R.drawable.loading).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+trailer.getVideoLink()));
                context.startActivity(intent);
            }
        });

    }

    class TrailerHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView videoName;
        TextView videoLink;
        public TrailerHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            videoName = (TextView) itemView.findViewById(R.id.videoName);
            videoLink = (TextView) itemView.findViewById(R.id.link);
        }
    }
}
