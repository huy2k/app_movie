package com.example.navigation;

import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFra();
            case 1:
                return new NotificationFra();
            case 2:
                return new UserFra();
            default:
                return new HomeFra();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

//    @NonNull
//    @Override
//   public Fragment createFragment(int position) {
////
////         }
//    }
//
//    @Override
//    public int getItemCount() {
//        return 3;
//    }
}
