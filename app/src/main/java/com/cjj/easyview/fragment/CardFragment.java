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
public class CardFragment extends Fragment{
    public static CardFragment newInstance() {
        CardFragment f = new CardFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new FragmentAdapter(getActivity(), Constants.TITLES));
        return rootView;
    }
}
