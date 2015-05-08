package com.cjj.easyview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.easyview.easyViewDemo.R;
import com.cjj.easyview.constants.Constants;

/**
 * Created by Administrator on 2015/3/19.
 * 侧边栏adapter
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> implements View.OnClickListener{
    private Context context;
    private String[] titles;

    public DrawerAdapter( Context context, String[] titles)
    {
        this.context = context;
        this.titles = titles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_recycleview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String content = titles[i];
        viewHolder.tv.setText(content);
        viewHolder.iv_drawer_icon.setBackgroundResource(Constants.ICON_DRAWER[i]);
        viewHolder.ll_item.setOnClickListener(this);
        viewHolder.ll_item.setTag(i);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_item:
                int pos = (int) v.getTag();
                Toast.makeText(context,"aaa"+pos,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;
        private ImageView iv_drawer_icon;
        private LinearLayout ll_item;
        public ViewHolder(View view) {
            super(view);
            ll_item = (LinearLayout) view.findViewById(R.id.ll_item);
            tv = (TextView) view.findViewById(R.id.tv_content);
            iv_drawer_icon = (ImageView) view.findViewById(R.id.iv_drawer_icon);
        }

    }
}
