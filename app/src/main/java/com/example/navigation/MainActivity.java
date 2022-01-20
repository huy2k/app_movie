package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.navigation.categories.Category;
import com.example.navigation.categories.CategoryAdapter;
import com.example.navigation.model.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private RecyclerView rcvCategory;
    private CategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_bottom);
        viewPager = findViewById(R.id.view_pager);
//        rcvCategory = findViewById(R.id.rcv_category);
//        adapter = new CategoryAdapter();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , RecyclerView.HORIZONTAL,false);

        setUpViewPager();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.notification:
                        Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.user:
                        Toast.makeText(MainActivity.this, "User", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });


    }
    private List<Category> getList() {
        List<Category> categoryList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1 ,"Sieu nhan",R.drawable.baseline_favorite_24, "hihi", (float) 4.6));
        movieList.add(new Movie(2 ,"Sieu nhan 1 ",R.drawable.baseline_favorite_24, "hihi", (float) 4.6));
        movieList.add(new Movie(3 ,"Sieu nhan",R.drawable.baseline_favorite_24, "hihi", (float) 4.6));
        categoryList.add(new Category(1, "Hanh dong" , movieList));
        return  categoryList;

    }
    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
    }
}