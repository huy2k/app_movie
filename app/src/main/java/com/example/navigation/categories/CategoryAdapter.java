package com.example.navigation.categories;

import com.example.navigation.HomeFra;
import com.example.navigation.R;
import com.example.navigation.movies.Movie;
import com.example.navigation.movies.MovieAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryHolder> {
    Context context;
//    int layout;
    List<Category> categories;

    public CategoryAdapter(Context context) {
        this.context = context;
//        this.layout = layout;
    }

    public void setData(List<Category> list){
        this.categories = list;

        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public categoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        return new CategoryAdapter.categoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryHolder holder, int position) {
        Category category  = categories.get(position);
        if(category == null){
            return;
        }
        holder.tvCategory.setText(category.categoryName);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        holder.rcvMovies.setLayoutManager(linearLayoutManager);

        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setData(category.getMovies());
        holder.rcvMovies.setAdapter(movieAdapter);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class categoryHolder extends RecyclerView.ViewHolder{
        RecyclerView rcvMovies;
        TextView tvCategory;
        public categoryHolder(@NonNull View itemView) {

            super(itemView);
            rcvMovies = itemView.findViewById(R.id.rcv_movie);
            tvCategory = itemView.findViewById(R.id.tv_Category);
        }


    }
}
