package com.cjj.easyview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.easyview.adapter.FragmentAdapter;
import com.cjj.easyview.easyViewDemo.R;
import com.cjj.easyview.constants.Constants;

public class SampleFragment extends Fragment {
    private RecyclerView recyclerView;
    public static SampleFragment newInstance(int position) {
        SampleFragment f = new SampleFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        return rootView;
    }
}