package com.cjj.easyview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.easyview.adapter.FragmentAdapter;
import com.cjj.easyview.constants.Constants;
import com.cjj.easyview.easyViewDemo.R;

/**
 * Created by Administrator on 2015/5/7.
 */
public class ImageFragment extends Fragment{
    public static ImageFragment newInstance() {
        ImageFragment f = new ImageFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_img, container, false);

        return rootView;
    }
}
