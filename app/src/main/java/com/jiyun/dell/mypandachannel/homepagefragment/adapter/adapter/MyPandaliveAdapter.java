package com.jiyun.dell.mypandachannel.homepagefragment.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class MyPandaliveAdapter extends RecyclerView.Adapter<MyPandaliveAdapter.ViewHolder> {

    private List<Shouye.DataBean.PandaliveBean.ListBean> list;
    private Context context;
    private OnClickListener onClickListener;

    public MyPandaliveAdapter(Context context, List<Shouye.DataBean.PandaliveBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pandalive, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.pandaliveName.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.pandaliveImg);
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

        @Bind(R.id.pandalive_img)
        ImageView pandaliveImg;
        @Bind(R.id.pandalive_name)
        TextView pandaliveName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }
}
