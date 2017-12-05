package com.jiyun.dell.mypandachannel.homepagefragment.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Shouye;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DELL zhanghuirong on 2017/11/22.
 */

public class MyAreaAdapter extends RecyclerView.Adapter<MyAreaAdapter.ViewHolder> {

    private List<Shouye.DataBean.AreaBean.ListscrollBean> list;
    private Context context;
    private OnClickListener onClickListener;

    public MyAreaAdapter(Context context, List<Shouye.DataBean.AreaBean.ListscrollBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_area, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.areaName.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.areaImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.setOnClickItemListener(view, position);

            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public interface OnClickListener {
        void setOnClickItemListener(View view, int position);

        void setOnLongClickListener(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.area_img)
        ImageView areaImg;
        @Bind(R.id.area_name)
        TextView areaName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
