package com.cjj.easyview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.easyview.easyViewDemo.R;

/**
 * Created by Administrator on 2015/5/7.
 */
public class ButtonFragment extends Fragment{
    public static ButtonFragment newInstance() {
        ButtonFragment f = new ButtonFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_btn, container, false);
        return rootView;
    }
}
