package com.jiyun.dell.mypandachannel.pandaslivefragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class MyTwoAdapter extends RecyclerView.Adapter {
    private final int BODY_VIEW = 1;
    private final List<Object> list;
    private final Context context;
    private final int HEAD_VIEW = 0;


    public MyTwoAdapter(Context context, List<Object> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        }
        if (list.get(position) instanceof Todal.ListBean) {

            return BODY_VIEW;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case HEAD_VIEW:
                View view1 = LayoutInflater.from(context).inflate(R.layout.head_view, null);
                holder = new HeadHolder(view1);
                break;
            case BODY_VIEW:
                View view = LayoutInflater.from(context).inflate(R.layout.item_two, null);
                holder = new MyHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEAD_VIEW:
//                HeadHolder holder2 = (HeadHolder) holder;
//                Game<XiongMao.DataBean.BigImgBean> bigImgBeen = (Game<XiongMao.DataBean.BigImgBean>) Game.get(position);
//
//                holder2.twoName.setText(bigImgBeen.get(0).getTitle());
//                Glide.with(context).load(bigImgBeen.get(0).getImage());
                break;
            case BODY_VIEW:
                MyHolder holder1 = (MyHolder) holder;
                List<Todal.ListBean> listBeen = (List<Todal.ListBean>) list.get(position);
                holder1.tvName.setText(listBeen.get(position).getTitle());
//                holder1.tvCon.setText(listBeen.get(position).getFocus_date());
                Glide.with(context).load(listBeen.get(position).getUrl()).into(holder1.img);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_con)
        TextView tvCon;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HeadHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.two_img)
        ImageView twoImg;
        @Bind(R.id.two_name)
        TextView twoName;

        public HeadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
