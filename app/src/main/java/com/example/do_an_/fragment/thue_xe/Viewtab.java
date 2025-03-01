package com.example.do_an_.fragment.thue_xe;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Viewtab extends FragmentStateAdapter {
    public Viewtab(@NonNull Fragment  fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position)
       {
           case 0:
               return new tu_lai();
           case 1:
               return  new co_tai_xe();
           default:
               return new tu_lai();
       }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
