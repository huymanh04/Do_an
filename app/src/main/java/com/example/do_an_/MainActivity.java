package com.example.do_an_;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.do_an_.fragment.tab_acc;
import com.example.do_an_.fragment.tab_chat;
import com.example.do_an_.fragment.tab_chuyen;
import com.example.do_an_.fragment.tab_home;
import com.example.do_an_.fragment.tab_sp;
import com.example.do_an_.fragment.thue_xe.Viewtab;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ViewPager2 view_pager;
    TabLayout tab_layout;
    private ViewPagerAdapter adapter;
    private LinearLayout home, chat, thue,suport,account;

    private ViewPager2 pager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //viewpage manu
        {
        viewPager = findViewById(R.id.viewPager);
            viewPager.setUserInputEnabled(false);
        home = findViewById(R.id.btnhome);
        thue = findViewById(R.id.btnthue);
        suport = findViewById(R.id.btnsp);
        account = findViewById(R.id.btnacc);
        chat = findViewById(R.id.btnchata);
        adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new tab_home());
        adapter.addFragment(new tab_chat());
        adapter.addFragment(new tab_chuyen());
        adapter.addFragment(new tab_sp());
        adapter.addFragment(new tab_acc());
        viewPager.setAdapter(adapter);
        home.setOnClickListener(v -> {
            viewPager.setCurrentItem(0);
            setTabBackground(home, chat, thue, suport, account);
        });

        chat.setOnClickListener(v -> {
            viewPager.setCurrentItem(1);
            setTabBackground(chat, home, thue, suport, account);
        });

        thue.setOnClickListener(v -> {
            viewPager.setCurrentItem(2);
            setTabBackground(thue, home, chat, suport, account);
        });

        suport.setOnClickListener(v -> {
            viewPager.setCurrentItem(3);
            setTabBackground(suport, home, chat, thue, account);
        });

        account.setOnClickListener(v -> {
            viewPager.setCurrentItem(4);
            setTabBackground(account, home, chat, thue, suport);
        });
        }
        //viewpage tablayout
        {


        }
    }
    private void setTabBackground(View selected, View... others) {
        selected.setBackgroundResource(R.drawable.tab_select);
        for (View tab : others) {
            tab.setBackgroundResource(android.R.color.transparent);
        }
    }
}