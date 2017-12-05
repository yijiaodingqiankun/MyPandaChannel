package com.jiyun.dell.mypandachannel.cctvfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.cctvfragment.bean.Game;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/27.
 */

public class MyListViewAdapter extends BaseAdapter {
    private List<Game.ListBean> listdata;
    private Context context;

    public MyListViewAdapter(Context context, List<Game.ListBean> listdata) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listdata != null ? listdata.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            holder.image = (ImageView) convertView.findViewById(R.id.img);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.con = (TextView) convertView.findViewById(R.id.tv_con);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        //设置文字
        holder.name.setText(listdata.get(position).getTitle());
//        String ptime = listdata.get(position).getPtime();
//        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = new Date(ptime);
//        String format = data.format(parent);
        holder.con.setText(listdata.get(position).getBrief());
        // Glide加载网络图片
        Glide.with(context).load(listdata.get(position).getImage()).into(holder.image);
        return convertView;
    }


    class ViewHolder {
        TextView name, con;
        ImageView image;
    }
}
