package com.example.do_an_.fragment;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.example.do_an_.R;
import com.example.do_an_.ViewPagerAdapter;
import com.example.do_an_.fragment.Home.ItemModel;
import com.example.do_an_.fragment.Home.ViewPagerAdapterhome;
import com.example.do_an_.fragment.Home.diadiemnoibat;
import com.example.do_an_.fragment.Home.sanbayadapter;
import com.example.do_an_.fragment.thue_xe.Viewtab;
import com.example.do_an_.fragment.thue_xe.co_tai_xe;
import com.example.do_an_.fragment.thue_xe.tu_lai;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tab_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab_home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tab_home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab_home.
     */
    // TODO: Rename and change types and number of parameters
    public static tab_home newInstance(String param1, String param2) {
        tab_home fragment = new tab_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }   private NestedScrollView nestedScrollView;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPager2 viewPager1;
    private ViewPagerAdapterhome adapter1;
    private ViewGroup.LayoutParams layoutParams;
    private Viewtab adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
      /// tìm hcuyeens các thứ
        {
        // Ánh xạ ViewPager2 & TabLayout
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_page);

        // Khởi tạo Adapter
        adapter = new Viewtab(this);

        viewPager.setAdapter(adapter);

        // Liên kết TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Xe tự lái");

                    break;
                case 1:
                    tab.setText("Xe có tài xế");
                    break;
            }
        }).attach();
        layoutParams = viewPager.getLayoutParams();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.view.setBackgroundColor(getResources().getColor(R.color.selected_tab)); // Màu khi chọn
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.view.setBackgroundColor(getResources().getColor(R.color.unselected_tab)); // Màu khi bỏ chọn
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Không cần xử lý
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                adjustTabLayoutHeight(position);
            }
        });
        }
        // chương trình khuyến maix
        {

            viewPager1 = view.findViewById(R.id.viewppppp);

            List<Integer> imageList = new ArrayList<>();
            imageList.add(R.drawable.img_4);
            imageList.add(R.drawable.img_1);
            imageList.add(R.drawable.img_2);
            imageList.add(R.drawable.img_2);
            imageList.add(R.drawable.img_2);
            adapter1 = new ViewPagerAdapterhome(imageList);
            viewPager1.setAdapter(adapter1);

            // Tạo khoảng cách giữa các item
            viewPager1.setOffscreenPageLimit(3);
            RecyclerView recyclerView = (RecyclerView) viewPager1.getChildAt(0);
            recyclerView.setClipToPadding(false);
            recyclerView.setClipChildren(false);
            recyclerView.setPadding(50, 0, 50, 0);
        }
        /// sn bay
        {
             RecyclerView recyclerView;
            sanbayadapter adapter;
             List<ItemModel> itemList;
            recyclerView = view.findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            // Khởi tạo danh sách dữ liệu
            itemList = new ArrayList<>();
            itemList.add(new ItemModel(R.drawable.img_1, "Tân Sơn Nhất", "1000+ xe"));
            itemList.add(new ItemModel(R.drawable.img_2, "Nội Bài", "200+ xe"));
            itemList.add(new ItemModel(R.drawable.img_3, "Đà Nẵng", "100+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));
            itemList.add(new ItemModel(R.drawable.img_4, "Cam Ranh", "50+ xe"));

            adapter = new sanbayadapter(itemList);
            recyclerView.setAdapter(adapter);
        }
        // địa đnooinonoi bat
        {
             RecyclerView recyclerView;
              diadiemnoibat    adapter;
             List<ItemModel> itemList;
            recyclerView = view.findViewById(R.id.recyclerView1);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            // Khởi tạo danh sách dữ liệu
            itemList = new ArrayList<>();
            itemList.add(new ItemModel(R.drawable.img_1, "Phú Quốc", "150+ xe"));
            itemList.add(new ItemModel(R.drawable.img_2, "Long An", "100+ xe"));
            itemList.add(new ItemModel(R.drawable.img_3, "Long An", "100+ xe"));
            itemList.add(new ItemModel(R.drawable.img_2, "Long An", "100+ xe"));
            adapter = new diadiemnoibat(itemList);
            recyclerView.setAdapter(adapter);
        }
            return view;
    }
    private void adjustTabLayoutHeight(int position) {
        if (position == 0) {
            layoutParams.height = dpToPx(280);
        } else {
            layoutParams.height = dpToPx(360);
        }
        viewPager.setLayoutParams(layoutParams);
    }
    private int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

}