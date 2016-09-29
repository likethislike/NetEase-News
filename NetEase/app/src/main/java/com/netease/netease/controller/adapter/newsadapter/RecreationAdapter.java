package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.newsbean.NewsRecreationBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块娱乐界面适配器
 */
public class RecreationAdapter extends BaseAdapter {
    private Context context;
    private List<NewsRecreationBean.T1348648517839Bean> datas;

    private static final int TYPE_NEWS_ALL_CONTENT = 0;
    private static final int TYPE_NEWS_ALL_PICTURE = 1;

    public RecreationAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsRecreationBean.T1348648517839Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (null != datas.get(position).getSkipType() && "photoset".equals(datas.get(position).getSkipType())) {
            return TYPE_NEWS_ALL_PICTURE;
        } else {
            return TYPE_NEWS_ALL_CONTENT;
        }
    }

    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecreationViewHolder recreationViewHolder = null;
        PictureViewHolder pictureViewHolder = null;

        int type = getItemViewType(position);

        if (convertView == null) {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_recreation, parent, false);
                    recreationViewHolder = new RecreationViewHolder(convertView);
                    convertView.setTag(recreationViewHolder);
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_all_news_picture, parent, false);
                    pictureViewHolder = new PictureViewHolder(convertView);
                    convertView.setTag(pictureViewHolder);
                    break;
            }

        } else {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    recreationViewHolder = (RecreationViewHolder) convertView.getTag();
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    pictureViewHolder = (PictureViewHolder) convertView.getTag();
            }
        }
        switch (type) {
            case TYPE_NEWS_ALL_CONTENT:
                Picasso.with(context).load(datas.get(position).getImgsrc()).into(recreationViewHolder.recreationImgIv);
                recreationViewHolder.recreationTitleTv.setText(datas.get(position).getTitle());
                recreationViewHolder.recreationSortTv.setText(datas.get(position).getSource());
                recreationViewHolder.recreationKindTv.setText(datas.get(position).getReplyCount() + "" + "跟贴");
                break;
            case TYPE_NEWS_ALL_PICTURE:
                pictureViewHolder.pictureTitleTv.setText(datas.get(position).getTitle());
                Picasso.with(context).load(datas.get(position).getImgsrc()).into(pictureViewHolder.oneImgIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(0).getImgsrc()).into(pictureViewHolder.twoImgIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(1).getImgsrc()).into(pictureViewHolder.threeImgIv);
                pictureViewHolder.websTv.setText(datas.get(position).getSource());
                pictureViewHolder.abroadTv.setText(datas.get(position).getReplyCount() + "跟帖");
                break;
        }

        return convertView;
    }

    class RecreationViewHolder {
        ImageView recreationImgIv;
        TextView recreationTitleTv;
        TextView recreationSortTv;
        TextView recreationKindTv;

        public RecreationViewHolder(View view) {
            recreationImgIv = (ImageView) view.findViewById(R.id.recreation_img);
            recreationTitleTv = (TextView) view.findViewById(R.id.recreation_title_tv);
            recreationSortTv = (TextView) view.findViewById(R.id.recreation_sort_tv);
            recreationKindTv = (TextView) view.findViewById(R.id.recreation_kind_tv);

        }
    }

    class PictureViewHolder {
        TextView pictureTitleTv;
        ImageView oneImgIv, twoImgIv, threeImgIv;
        TextView websTv, abroadTv;

        public PictureViewHolder(View view) {
            pictureTitleTv = (TextView) view.findViewById(R.id.news_all_title_tv);
            oneImgIv = (ImageView) view.findViewById(R.id.news_all_one_img_iv);
            twoImgIv = (ImageView) view.findViewById(R.id.news_all_two_img_iv);
            threeImgIv = (ImageView) view.findViewById(R.id.news_all_three_img_iv);
            websTv = (TextView) view.findViewById(R.id.news_all_webs_tv);
            abroadTv = (TextView) view.findViewById(R.id.news_all_abroad_tv);
        }
    }
}
