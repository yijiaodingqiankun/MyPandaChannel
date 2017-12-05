package com.jiyun.dell.mypandachannel.LiveChinaFragment.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Live;
import com.jiyun.dell.mypandachannel.R;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/4.
 */

class MyListViewLiveAdapter extends BaseAdapter {
    private final Context context;
    private final List<Live.LiveBean> list;
    private boolean jianji;

    public MyListViewLiveAdapter(Context context, List<Live.LiveBean> list) {
        this.context = context;
        this.list = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_list_live, null);
            holder.img = convertView.findViewById(R.id.img);
            holder.name = convertView.findViewById(R.id.tv_name);
            holder.con = convertView.findViewById(R.id.tv_con);
            holder.imgs = convertView.findViewById(R.id.imgfack);
            holder.cons = convertView.findViewById(R.id.tv_cons);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(0).getImage()).into(holder.img);
        holder.name.setText(list.get(position).getTitle());
        holder.cons.setText(list.get(position).getBrief());


        holder.imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jianji) {
                    Glide.with(context).load(R.drawable.com_facebook_tooltip_black_bottomnub).into(holder.imgs);
                    holder.cons.setVisibility(View.VISIBLE);
                    jianji = false;
                } else {
                    Glide.with(context).load(R.drawable.com_facebook_tooltip_black_topnub).into(holder.imgs);
                    holder.cons.setVisibility(View.GONE);
                    jianji = true;
                }
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        ImageView img, imgs;
        TextView name, con, cons;
    }
}
