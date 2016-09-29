package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.newsbean.NewsHeadlineBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/13.
 * 头条网络解析适配器
 */
public class HeadLinesAdapter extends BaseAdapter{
    private Context context;
    private List<NewsHeadlineBean.T1348647909107Bean> datas;

    public HeadLinesAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsHeadlineBean.T1348647909107Bean> datas) {
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
        HeadlineViewHolder headlineViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_headline,parent,false);
            headlineViewHolder = new HeadlineViewHolder(convertView);
            convertView.setTag(headlineViewHolder);
        }else {
            headlineViewHolder = (HeadlineViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImgsrc()).into(headlineViewHolder.headlineIv);
        headlineViewHolder.titleTv.setText(datas.get(position).getTitle());

        return convertView;
    }

    /**
     * 创建缓存类
     */
    class HeadlineViewHolder{
        ImageView headlineIv;
        TextView titleTv;
        TextView sortTv;
        TextView kindTv;


        public HeadlineViewHolder(View view){
            headlineIv = (ImageView) view.findViewById(R.id.headline_img);
            titleTv = (TextView) view.findViewById(R.id.headline_title_tv);
            sortTv = (TextView) view.findViewById(R.id.headline_sort_tv);
            kindTv = (TextView) view.findViewById(R.id.headline_kind_tv);

        }
    }
}
