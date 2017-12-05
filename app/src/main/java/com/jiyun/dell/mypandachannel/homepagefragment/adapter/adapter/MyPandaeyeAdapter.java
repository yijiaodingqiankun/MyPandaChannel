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
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Pandaeye;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DELL zhanghuirong on 2017/11/22.
 */

public class MyPandaeyeAdapter extends RecyclerView.Adapter<MyPandaeyeAdapter.ViewHolder> {

    private List<Pandaeye.ListBean> list;
    private Context context;
    private OnClickListener onClickListener;

    public MyPandaeyeAdapter(Context context, List<Pandaeye.ListBean> list) {
        this.context = context;
        Log.e( "MyPandaeyeAdapter: ","4444444444444"+list.size() );
        this.list = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pandaeye, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.pandaTvName.setText(list.get(position).getTitle());
        holder.pandaTvCon.setText(list.get(position).getDaytime());
        Glide.with(context).load(list.get(position).getImage()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.setOnClickItemListener(view, position);

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("TAg",list.size()+"hahahahha");
        return list.size();
    }

    public interface OnClickListener {
        void setOnClickItemListener(View view, int position);

        void setOnLongClickListener(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.panda_tv_name)
        TextView pandaTvName;
        @Bind(R.id.panda_tv_con)
        TextView pandaTvCon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }
}
