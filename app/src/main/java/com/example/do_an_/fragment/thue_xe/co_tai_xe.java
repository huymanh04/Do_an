package com.example.do_an_.fragment.thue_xe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.do_an_.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link co_tai_xe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class co_tai_xe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public co_tai_xe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment co_tai_xe.
     */
    // TODO: Rename and change types and number of parameters
    public static co_tai_xe newInstance(String param1, String param2) {
        co_tai_xe fragment = new co_tai_xe();
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
    }
    private Spinner spinnerTripType;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_co_tai_xe, container, false);
        view.getLayoutParams().height = dpToPx(368);
        return view;
    } private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}