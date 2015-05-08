package com.cjj.easyview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.easyview.easyViewDemo.R;

/**
 * Created by Administrator on 2015/3/19.
 */
public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder> {
    private Context context;
    private String[] titles;

    public FragmentAdapter( Context context, String[] titles)
    {
        this.context = context;
        this.titles = titles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_view,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String content = titles[i];
        viewHolder.tv.setText(content);
        if(i==0)
        {
            viewHolder.iv.setImageResource(R.drawable.a4);
        }else if(i == 1)
        {
            viewHolder.iv.setImageResource(R.drawable.a3);
        }else if(i == 2)
        {
            viewHolder.iv.setImageResource(R.drawable.a2);
        }else {
            viewHolder.iv.setImageResource(R.drawable.a1);
        }

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;
        private ImageView iv;
        public ViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.name);
            iv = (ImageView) view.findViewById(R.id.pic);
        }

    }
}
