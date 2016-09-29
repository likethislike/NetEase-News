package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.newsbean.NewsFeaturedBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块精选界面适配器
 */
public class FeaturedAdapter extends BaseAdapter {
    private Context context;
    private static final int TYPE_NEWS_ALL_CONTENT = 0;
    private static final int TYPE_NEWS_ALL_PICTURE = 1;
    private static final int TYPE_NEWS_ALL_ORIGINALITY = 2;


    private List<NewsFeaturedBean.T1467284926140Bean> datas;

    public FeaturedAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsFeaturedBean.T1467284926140Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();

    }

    public int getItemViewType(int position) {
        if (datas.get(position).getOrder() == 1 && datas.get(position).getHasHead() != 1 ) {
            return TYPE_NEWS_ALL_CONTENT;
        } else if (null != datas.get(position).getSkipType() && "photoset".equals(datas.get(position).getSkipType())&& datas.get(position).getHasHead() != 1) {

            return TYPE_NEWS_ALL_PICTURE;
        }

        else if (datas.get(position).getImgType() == 1) {

            return TYPE_NEWS_ALL_ORIGINALITY;

        } else {

            return 0;
        }

    }

    /**
     * 行布局类型总数
     *
     * @return
     */
    public int getViewTypeCount() {
        return 3;
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
        FeaturedViewHolder featuredViewHolder = null;
        PictureViewHolder pictureViewHolder = null;
        OriginalityViewHolder originalityViewHolder = null;

        int type = getItemViewType(position);


        if (convertView == null) {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_featured, parent, false);
                    featuredViewHolder = new FeaturedViewHolder(convertView);
                    convertView.setTag(featuredViewHolder);
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_all_news_picture, parent, false);
                    pictureViewHolder = new PictureViewHolder(convertView);
                    convertView.setTag(pictureViewHolder);
                    break;
                case TYPE_NEWS_ALL_ORIGINALITY:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_all_news_originality,parent,false);
                    originalityViewHolder = new OriginalityViewHolder(convertView);
                    convertView.setTag(originalityViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    featuredViewHolder = (FeaturedViewHolder) convertView.getTag();
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    pictureViewHolder = (PictureViewHolder) convertView.getTag();
                    break;
                case TYPE_NEWS_ALL_ORIGINALITY:
                    originalityViewHolder = (OriginalityViewHolder) convertView.getTag();
            }
        }
        switch (type) {
            case TYPE_NEWS_ALL_CONTENT:
                Picasso.with(context).load(datas.get(position ).getImgsrc()).into(featuredViewHolder.featuredImgIv);
                featuredViewHolder.featuredTitleTv.setText(datas.get(position).getTitle());
                Log.d("www", "position:" + position);
                featuredViewHolder.featuredSortTv.setText(datas.get(position).getSource());
                featuredViewHolder.featuredKindTv.setText(datas.get(position).getReplyCount() + "跟帖");
                break;
            case TYPE_NEWS_ALL_PICTURE:
                pictureViewHolder.pictureTitleTv.setText(datas.get(position).getTitle());
                Picasso.with(context).load(datas.get(position).getImgsrc()).into(pictureViewHolder.oneImgIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(0).getImgsrc()).into(pictureViewHolder.twoImgIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(1).getImgsrc()).into(pictureViewHolder.threeImgIv);
                pictureViewHolder.websTv.setText(datas.get(position).getSource());
                pictureViewHolder.abroadTv.setText(datas.get(position).getReplyCount() + "跟帖");
                break;
            case TYPE_NEWS_ALL_ORIGINALITY:
                originalityViewHolder.orTitleTv.setText(datas.get(position).getTitle());
                Picasso.with(context).load(datas.get(position).getImgsrc()).into(originalityViewHolder.orImgIv);
                originalityViewHolder.orSourceTv.setText(datas.get(position).getSource());
                originalityViewHolder.orCountTv.setText(datas.get(position).getReplyCount());
        }
            return convertView;
    }
    class FeaturedViewHolder {
        ImageView featuredImgIv;
        TextView featuredTitleTv;
        TextView featuredSortTv;
        TextView featuredKindTv;

        public FeaturedViewHolder(View view) {
            featuredImgIv = (ImageView) view.findViewById(R.id.featured_img);
            featuredTitleTv = (TextView) view.findViewById(R.id.featured_title_tv);
            featuredSortTv = (TextView) view.findViewById(R.id.featured_sort_tv);
            featuredKindTv = (TextView) view.findViewById(R.id.featured_kind_tv);
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

    class OriginalityViewHolder {
        TextView orTitleTv;
        ImageView orImgIv;
        TextView orSourceTv;
        TextView orCountTv;
        ImageView orCountIv;

        public OriginalityViewHolder(View view) {
            orTitleTv = (TextView) view.findViewById(R.id.news_all_originality_title_tv);
            orImgIv = (ImageView) view.findViewById(R.id.news_all_originality_image_iv);
            orSourceTv = (TextView) view.findViewById(R.id.news_all_originality_source_tv);
            orCountTv = (TextView) view.findViewById(R.id.news_all_originality_count);
            orCountIv = (ImageView) view.findViewById(R.id.news_all_originality_count_img);

        }
    }

}
