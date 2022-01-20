package com.example.navigation.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigation.R;
import com.example.navigation.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.recyleviewHolder> {

    private List<Movie> lMovies;
    public void setData(List<Movie> list){
        this.lMovies = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public recyleviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new recyleviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyleviewHolder holder, int position) {
        Movie movie = lMovies.get(position);
        if(movie == null){
            return;
        }
        holder.imgMovie.setImageResource(movie.getImage());
        holder.tvTitle.setText(movie.getTitle());
//        MovieAdapter movieAdapter = new MovieAdapter();
//        movieAdapter.setData(movie);
    }

    @Override
    public int getItemCount() {
        if(lMovies != null) return lMovies.size();
        return 0;
    }

    public static class recyleviewHolder extends RecyclerView.ViewHolder{
        public ImageView imgMovie;
        public TextView tvTitle;
        public recyleviewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.image_mv);
            tvTitle = itemView.findViewById(R.id.tv_title);

        }
    }
}
