package com.jiyun.dell.mypandachannel.homepagefragment.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.homepagefragment.adapter.adapter.MyAreaAdapter;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Cctv;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.GuanYing;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Pandaeye;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Shouye;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by DELL zhanghuirong on 2017/11/20.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private static final int BANNER = 0;
    private static final int AREA = 1;
    private static final int PANDAEYE = 2;
    private static final int PANDALIVE = 3;
    private static final int WALLLIVE = 4;
    private static final int CHINALIVE = 5;
    private static final int INTERACTIVE = 6;
    private static final int CCTV = 7;
    private static final int LIST = 8;
    private final List<Object> list;


    private Context context;
    private OnClickListener onClickListener;
    public List<Pandaeye.ListBean> listPandaeye;
    private List<GuanYing.ListBean> listGuan;
    private List<Cctv.ListBean> listcctv;
    private String TAG;

    public MyAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return BANNER;
        }
        if (list.get(position) instanceof Shouye.DataBean.AreaBean) {
            return AREA;
        }
        if (list.get(position) instanceof Shouye.DataBean.PandaeyeBean) {
            return PANDAEYE;
        }
        if (list.get(position) instanceof Shouye.DataBean.PandaliveBean) {
            return PANDALIVE;
        }
        if (list.get(position) instanceof Shouye.DataBean.WallliveBean) {
            return WALLLIVE;
        }
        if (list.get(position) instanceof Shouye.DataBean.ChinaliveBean) {
            return CHINALIVE;
        }
        if (list.get(position) instanceof Shouye.DataBean.InteractiveBean) {
            return INTERACTIVE;
        }
        if (list.get(position) instanceof Shouye.DataBean.CctvBean) {
            return CCTV;
        }
        if (list.get(position) instanceof Shouye.DataBean.ListBeanXXX) {
            return LIST;
        }

        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.item_buju, null);
                holder = new BannerViewHolder(view);
                break;
            case 1:
                //精彩推荐
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_goodrecommendation, null);
                holder = new GoodRecommendationViewHolder(view1);
                break;
            case 2:
                //           熊猫观察
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_pandaobserver, null);
                holder = new PandaObserverViewHolder(view2);
                break;
            case 3:
                //熊猫直播
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_pandaslive, null);
                holder = new PandasLiveViewHolder(view3);
                break;
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_pandaslive, null);
                holder = new WallLiveViewHolder(view4);
                break;
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.item_pandaslive, null);
                holder = new LiveChinaViewHolder(view5);
                break;
            case 6:
                //特别策划
                View view6 = LayoutInflater.from(context).inflate(R.layout.item_special, null);
                holder = new SpecialViewHolder(view6);
                break;
            case 7:
                //CCTV
                View view7 = LayoutInflater.from(context).inflate(R.layout.item_cctv, null);
                holder = new CctvViewHolder(view7);
                break;
            case 8:
                //光影中国
                View view8 = LayoutInflater.from(context).inflate(R.layout.item_lightchina, null);
                holder = new LightChinaViewHolder(view8);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                //轮播图
              /*  Game<String> list1 = new ArrayList<>();
                Game<String> listTitle = new ArrayList<>();
                Object o = Game.get(position);
                Game<Shouye.DataBean.BigImgBean> o1 = (Game<Shouye.DataBean.BigImgBean>) o;
                for (int i = 0; i < o1.size(); i++) {
                    String image = o1.get(i).getImage();
                    list1.add(image);
                    String title = o1.get(i).getTitle();
                    listTitle.add(title);
                }

                BannerViewHolder holder1 = (BannerViewHolder) holder;
                holder1.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                //设置图片加载器
                holder1.banner.setImageLoader(new GlideImageLoder());
                //设置图片集合
                holder1.banner.setImages(list1);
                //设置banner动画效果
                holder1.banner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                holder1.banner.setBannerTitles(listTitle);
                //设置自动轮播，默认为true
                holder1.banner.isAutoPlay(true);
                //设置轮播时间
                holder1.banner.setDelayTime(1500);
                //设置指示器位置（当banner模式中有指示器时）
                holder1.banner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                holder1.banner.start();*/
                break;
            case 1:
                //精彩推荐
                Shouye.DataBean.AreaBean areaBean = (Shouye.DataBean.AreaBean) list.get(position);
                String title = areaBean.getTitle();
                String image = areaBean.getImage();
                List<Shouye.DataBean.AreaBean.ListscrollBean> listscroll = areaBean.getListscroll();

                GoodRecommendationViewHolder holder2 = (GoodRecommendationViewHolder) holder;
                holder2.jcTvText.setText(title);
                Glide.with(context).load(image).into(holder2.jcImg);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                holder2.jcRecycler.setLayoutManager(manager);
                MyAreaAdapter adapter = new MyAreaAdapter(context, listscroll);
                holder2.jcRecycler.setAdapter(adapter);

                break;
            case 2:
                //熊猫观察
                Shouye.DataBean.PandaeyeBean listpanda = (Shouye.DataBean.PandaeyeBean) list.get(position);
                String title1 = listpanda.getTitle();
                String pandaeyelogo = listpanda.getPandaeyelogo();
                List<Shouye.DataBean.PandaeyeBean.ItemsBean> items = listpanda.getItems();

                String brief = items.get(0).getBrief();
                String title2 = items.get(0).getTitle();
                String brief1 = items.get(1).getBrief();
                String title3 = items.get(1).getTitle();
                String url = listpanda.getPandaeyelist();

                retrofit2.Call<Pandaeye> getpanda = RetrofitUtil.getInstance().getpanda();
                getpanda.enqueue(new retrofit2.Callback<Pandaeye>() {
                    @Override
                    public void onResponse(retrofit2.Call<Pandaeye> call, retrofit2.Response<Pandaeye> response) {
                        listPandaeye = response.body().getList();
                        Log.e(TAG, "onResponse:555555555 " + listPandaeye.size());
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Pandaeye> call, Throwable t) {
                        Log.e(TAG, "onFailure:===== " + t.getMessage());
                    }
                });

                PandaObserverViewHolder holder3 = (PandaObserverViewHolder) holder;
                holder3.tvXmgc.setText(title1);
                holder3.tvXmgcQw.setText(title2);
                holder3.tvXmgcQw2.setText(title3);
                holder3.tvXmgcXs.setText(brief);
                holder3.tvXmgcXs2.setText(brief1);
                Glide.with(context).load(pandaeyelogo).into(holder3.ivImgXmgc);

//                LinearLayoutManager manager1 = new LinearLayoutManager(context);
//                manager1.setOrientation(LinearLayoutManager.VERTICAL);
//                holder3.xmgcRecycler.setLayoutManager(manager1);
//                MyPandaeyeAdapter adapter1 = new MyPandaeyeAdapter(context, listPandaeye);
//                holder3.xmgcRecycler.setAdapter(adapter1);
                break;
            case 3:
                //熊猫直播
                Shouye.DataBean.PandaliveBean pandaliveBean = (Shouye.DataBean.PandaliveBean) list.get(position);
                String title4 = pandaliveBean.getTitle();
                List<Shouye.DataBean.PandaliveBean.ListBean> listListBean = pandaliveBean.getList();


                PandasLiveViewHolder holder4 = (PandasLiveViewHolder) holder;
                holder4.tvPandaLive.setText(title4);

//                GridLayoutManager manager2 = new GridLayoutManager(context, 3);
//                manager2.setOrientation(GridLayoutManager.VERTICAL);
//                holder4.pandasliveRecycler.setLayoutManager(manager2);
//                MyPandaliveAdapter myadapter = new MyPandaliveAdapter(context, listListBean);
//                holder4.pandasliveRecycler.setAdapter(myadapter);
//                myadapter.notifyDataSetChanged();

                break;
            case 4:
                //长城直播
                Shouye.DataBean.WallliveBean wallliveBean = (Shouye.DataBean.WallliveBean) list.get(position);
                String title5 = wallliveBean.getTitle();
                List<Shouye.DataBean.WallliveBean.ListBeanX> listwallliveBean = wallliveBean.getList();


                WallLiveViewHolder holder5 = (WallLiveViewHolder) holder;
                holder5.tvPandaLive.setText(title5);
//                GridLayoutManager manager4 = new GridLayoutManager(context, 3);
//                manager4.setOrientation(GridLayoutManager.VERTICAL);
//                holder5.pandasliveRecycler.setLayoutManager(manager4);
//                MyPandaliveAdapter myadapter4 = new MyPandaliveAdapter(context, listListBean);
//                holder5.pandasliveRecycler.setAdapter(myadapter4);
                break;
            case 5:
                //直播中国
                Shouye.DataBean.ChinaliveBean chinaliveBean = (Shouye.DataBean.ChinaliveBean) list.get(position);
                String title6 = chinaliveBean.getTitle();
                List<Shouye.DataBean.ChinaliveBean.ListBeanXX> listchinaliveBean = chinaliveBean.getList();


                LiveChinaViewHolder holder6 = (LiveChinaViewHolder) holder;
                holder6.tvPandaLive.setText(title6);
//                GridLayoutManager manager2 = new GridLayoutManager(context, 3);
//                manager2.setOrientation(GridLayoutManager.VERTICAL);
//                holder6.pandasliveRecycler.setLayoutManager(manager2);
//                MyPandaliveAdapter myadapter=new MyPandaliveAdapter(context,listListBean);
//                holder6.pandasliveRecycler.setAdapter(myadapter);
                break;
            case 6:
                //特别策划
                Shouye.DataBean.InteractiveBean interactiveBean = (Shouye.DataBean.InteractiveBean) list.get(position);
                String title7 = interactiveBean.getTitle();
                List<Shouye.DataBean.InteractiveBean.InteractiveoneBean> interactiveone = interactiveBean.getInteractiveone();


                SpecialViewHolder holder7 = (SpecialViewHolder) holder;
                holder7.ivChName.setText(interactiveone.get(0).getTitle());
//                holder7.llCh.setOnClickListener();
                holder7.tvTbch.setText(title7);
                Glide.with(context).load(interactiveone.get(0).getImage()).into(holder7.ivChImg);
                break;
            case 7:
                //CCTV
                Shouye.DataBean.CctvBean cctvBean = (Shouye.DataBean.CctvBean) list.get(position);
                String cctvBeanTitle = cctvBean.getTitle();
                //url
                String listurl = cctvBean.getListurl();


                CctvViewHolder holder8 = (CctvViewHolder) holder;

                holder8.cctvName.setText(cctvBeanTitle);

//                GridLayoutManager manager3 = new GridLayoutManager(context, 2);
//                manager3.setOrientation(GridLayoutManager.VERTICAL);
//                holder8.cctvRecycler.setLayoutManager(manager3);
//                MyCctvAdapter adapter7 = new MyCctvAdapter(context, listcctv);
//                holder8.cctvRecycler.setAdapter(adapter7);

                break;
            case 8:
                List<Shouye.DataBean.ListBeanXXX> listBeanXXXes = (List<Shouye.DataBean.ListBeanXXX>) list.get(position);
                //url
                String listUrl = listBeanXXXes.get(0).getListUrl();
                String title8 = listBeanXXXes.get(0).getTitle();
                Call<GuanYing> guanying = RetrofitUtil.getInstance().getGuanying();
                guanying.enqueue(new Callback<GuanYing>() {
                    @Override
                    public void onResponse(Call<GuanYing> call, Response<GuanYing> response) {
                        listGuan = response.body().getList();
                    }

                    @Override
                    public void onFailure(Call<GuanYing> call, Throwable t) {

                    }
                });

                LightChinaViewHolder holder9 = (LightChinaViewHolder) holder;
                holder9.gyzgName.setText(title8);

//                LinearLayoutManager manager4 = new LinearLayoutManager(context);
//                holder9.gyzgRecycler.setLayoutManager(manager4);
//                MyGuanAdapter adapter8 = new MyGuanAdapter(context, listGuan);
//                holder9.gyzgRecycler.setAdapter(adapter8);
                break;

        }
    }


    @Override
    public int getItemCount() {
        Log.e("0000000000", "getItemCount: ---------" + list.size());
        return list.size();
    }

    public interface OnClickListener {
        void setOnClickItemListener(View view, int position);

        void setOnLongClickListener(View view, int position);

    }

    //首页——轮播图
    public class BannerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.banner)
        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——精彩推荐 1
    public class GoodRecommendationViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.jc_img)
        ImageView jcImg;
        @Bind(R.id.jc_tv_text)
        TextView jcTvText;
        @Bind(R.id.jc_recycler)
        RecyclerView jcRecycler;

        public GoodRecommendationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——熊猫观察 2
    public class PandaObserverViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_xmgc)
        TextView tvXmgc;
        @Bind(R.id.iv_img_xmgc)
        ImageView ivImgXmgc;
        @Bind(R.id.tv_xmgc_xs)
        TextView tvXmgcXs;
        @Bind(R.id.tv_xmgc_qw)
        TextView tvXmgcQw;
        @Bind(R.id.tv_xmgc_xs2)
        TextView tvXmgcXs2;
        @Bind(R.id.tv_xmgc_qw2)
        TextView tvXmgcQw2;
        @Bind(R.id.xmgc_recycler)
        RecyclerView xmgcRecycler;

        public PandaObserverViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——熊猫直播 3
    public class PandasLiveViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_panda_live)
        TextView tvPandaLive;
        @Bind(R.id.pandaslive_recycler)
        RecyclerView pandasliveRecycler;

        public PandasLiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——长城直播 4
    public class WallLiveViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_panda_live)
        TextView tvPandaLive;
        @Bind(R.id.pandaslive_recycler)
        RecyclerView pandasliveRecycler;

        public WallLiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——直播中国 5
    public class LiveChinaViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_panda_live)
        TextView tvPandaLive;
        @Bind(R.id.pandaslive_recycler)
        RecyclerView pandasliveRecycler;

        public LiveChinaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——特别策划 6
    public class SpecialViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.tv_tbch)
        TextView tvTbch;
        @Bind(R.id.iv_ch_img)
        ImageView ivChImg;
        @Bind(R.id.iv_ch_name)
        TextView ivChName;
        @Bind(R.id.ll_ch)
        LinearLayout llCh;

        public SpecialViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    //首页——CCTV 7
    public class CctvViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.cctv_name)
        TextView cctvName;
        @Bind(R.id.cctv_recycler)
        RecyclerView cctvRecycler;

        public CctvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


    //首页——光影中国 8
    public class LightChinaViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.gyzg_name)
        TextView gyzgName;
        @Bind(R.id.gyzg_recycler)
        RecyclerView gyzgRecycler;

        public LightChinaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
