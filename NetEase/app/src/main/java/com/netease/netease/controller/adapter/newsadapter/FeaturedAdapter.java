package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
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
 */
public class FeaturedAdapter extends BaseAdapter {
    private Context context;
    private List<NewsFeaturedBean.T1467284926140Bean> datas;

    public FeaturedAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsFeaturedBean.T1467284926140Bean> datas) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FeaturedViewHolder featuredViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_featured,parent,false);
            featuredViewHolder = new FeaturedViewHolder(convertView);
            convertView.setTag(featuredViewHolder);
        }else {
            featuredViewHolder = (FeaturedViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImgsrc()).into(featuredViewHolder.featuredImgIv);
        featuredViewHolder.featuredTitleTv.setText(datas.get(position).getTitle());
        featuredViewHolder.featuredSortTv.setText(datas.get(position).getSource());
        featuredViewHolder.featuredKindTv.setText(datas.get(position).getReplyCount() + "跟帖");


        return convertView;
    }
    class FeaturedViewHolder{
        ImageView featuredImgIv;
        TextView featuredTitleTv;
        TextView featuredSortTv;
        TextView featuredKindTv;
        public FeaturedViewHolder(View view){
            featuredImgIv = (ImageView) view.findViewById(R.id.featured_img);
            featuredTitleTv = (TextView) view.findViewById(R.id.featured_title_tv);
            featuredSortTv = (TextView) view.findViewById(R.id.featured_sort_tv);
            featuredKindTv = (TextView) view.findViewById(R.id.featured_kind_tv);
        }


    }
}
