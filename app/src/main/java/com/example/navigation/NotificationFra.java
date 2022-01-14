package com.example.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigation.movies.Movie;
import com.example.navigation.movies.MovieAdapter;

import java.util.ArrayList;

public class NotificationFra extends Fragment {
    ListView lv;
    ArrayList<Movie> lvList;
    movieAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_notification, container, false);
        lv = view.findViewById(R.id.lv);
        lvList  = new ArrayList<>();
        lvList.add(new Movie(1 ,"Sieu nhan",R.drawable.p5, "hihi", (float) 4.6));
        lvList.add(new Movie(2 ,"Sieu nhan 1 ",R.drawable.p6 , "hihi", (float) 4.6));
        lvList.add(new Movie(3 ,"Sieu nhan",R.drawable.p8, "hihi", (float) 4.6));
        lvList.add(new Movie(4 ,"Sieu nhan",R.drawable.phim2, "hihi", (float) 4.6));

        adapter = new movieAdapter(getContext(), R.layout.movies , lvList);
        lv.setAdapter(adapter);
        return view;
    }
}
