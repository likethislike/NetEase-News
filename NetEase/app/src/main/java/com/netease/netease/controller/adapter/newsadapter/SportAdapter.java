package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.newsbean.NewsSportsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 新闻模块,体育界面适配器
 */
public class SportAdapter extends BaseAdapter {

    private Context context;
    private List<NewsSportsBean.T1348649079062Bean> datas;
    private LayoutInflater inflater;
    private static final int TYPE_NEWS_ALL_CONTENT = 0;
    private static final int TYPE_NEWS_ALL_PICTURE = 1;
    private static final int TYPE_NEWS_ALL_ORIGINALITY = 2;

    public SportAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<NewsSportsBean.T1348649079062Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
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

    /**
     * 根据position位置获取数据集合的数据
     * 返回行布局类型
     */
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
     */
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContentViewHolder contentViewHolder = null;
        PictureViewHolder pictureViewHolder = null;
        int type = getItemViewType(position);
        /**
         * 加载行布局 + 缓存行布局组件
         */
        if (convertView == null) {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    convertView = inflater.inflate(R.layout.item_all_news_content, parent, false);
                    contentViewHolder = new ContentViewHolder(convertView);
                    convertView.setTag(contentViewHolder);
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    convertView = inflater.inflate(R.layout.item_all_news_picture, parent, false);
                    pictureViewHolder = new PictureViewHolder(convertView);
                    convertView.setTag(pictureViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_NEWS_ALL_CONTENT:
                    contentViewHolder = (ContentViewHolder) convertView.getTag();
                    break;
                case TYPE_NEWS_ALL_PICTURE:
                    pictureViewHolder = (PictureViewHolder) convertView.getTag();
            }

        }
        NewsSportsBean.T1348649079062Bean bean = datas.get(position);
        switch (type) {
            case TYPE_NEWS_ALL_CONTENT:
                Picasso.with(context).load(bean.getImgsrc()).into(contentViewHolder.contentIv);
                contentViewHolder.contentTitleTv.setText(bean.getTitle());
                contentViewHolder.contentSortTv.setText(bean.getSource());
                contentViewHolder.contentKindTv.setText(bean.getReplyCount() + "跟帖");

                break;
            case TYPE_NEWS_ALL_PICTURE:
                pictureViewHolder.pictureTitleTv.setText(bean.getTitle());
                Picasso.with(context).load(bean.getImgsrc()).into(pictureViewHolder.pictureOneIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(0).getImgsrc()).into(pictureViewHolder.pictureTwoIv);
                Picasso.with(context).load(datas.get(position).getImgextra().get(1).getImgsrc()).into(pictureViewHolder.pictureThreeIv);
                pictureViewHolder.pictureWebTv.setText(bean.getSource());
                pictureViewHolder.pictureAbrodTv.setText(bean.getReplyCount() + "跟帖");
                break;
        }
        return convertView;
    }

    /**
     * 内容缓存类
     */

    class ContentViewHolder {
        ImageView contentIv;
        TextView contentTitleTv;
        TextView contentSortTv;
        TextView contentKindTv;

        public ContentViewHolder(View view) {
            super();
            contentIv = (ImageView) view.findViewById(R.id.news_all_img_iv);
            contentTitleTv = (TextView) view.findViewById(R.id.news_all_content_title_tv);
            contentSortTv = (TextView) view.findViewById(R.id.news_all_sort_tv);
            contentKindTv = (TextView) view.findViewById(R.id.news_all_kind_tv);
        }
    }

    /**
     * 图片缓存类
     */

    class PictureViewHolder {
        TextView pictureTitleTv;
        ImageView pictureOneIv;
        ImageView pictureTwoIv;
        ImageView pictureThreeIv;
        TextView pictureWebTv;
        TextView pictureAbrodTv;

        public PictureViewHolder(View view) {
            pictureTitleTv = (TextView) view.findViewById(R.id.news_all_title_tv);
            pictureOneIv = (ImageView) view.findViewById(R.id.news_all_one_img_iv);
            pictureTwoIv = (ImageView) view.findViewById(R.id.news_all_two_img_iv);
            pictureThreeIv = (ImageView) view.findViewById(R.id.news_all_three_img_iv);
            pictureWebTv = (TextView) view.findViewById(R.id.news_all_webs_tv);
            pictureAbrodTv = (TextView) view.findViewById(R.id.news_all_abroad_tv);
        }
    }
}
