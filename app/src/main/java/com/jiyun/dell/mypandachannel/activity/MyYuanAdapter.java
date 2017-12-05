package com.jiyun.dell.mypandachannel.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Jieqi;
import com.jiyun.dell.mypandachannel.R;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/4.
 */

class MyYuanAdapter extends BaseAdapter {
    private final Context context;
    private final List<Jieqi.InteractiveBean> list;

    public MyYuanAdapter(Context context, List<Jieqi.InteractiveBean> interactive) {
        this.context = context;
        this.list = interactive;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_yuan, null);
            holder.ll = convertView.findViewById(R.id.ll);
            holder.title = convertView.findViewById(R.id.title);
            holder.img = convertView.findViewById(R.id.img_ic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getImage()).into(holder.img);
        holder.title.setText(list.get(position).getTitle());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangActivity.class);

                intent.putExtra("url", list.get(position).getUrl());

                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView title;
        ImageView img;
        LinearLayout ll;
    }
}
