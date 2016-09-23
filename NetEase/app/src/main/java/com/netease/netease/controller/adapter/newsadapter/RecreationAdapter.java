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
public class RecreationAdapter extends BaseAdapter{
    private Context context;
    private List<NewsRecreationBean.T1348648517839Bean> datas;

    public RecreationAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsRecreationBean.T1348648517839Bean> datas) {
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
        RecreationViewHolder recreationViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recreation,parent,false);
            recreationViewHolder = new RecreationViewHolder(convertView);
            convertView.setTag(recreationViewHolder);
        }else {
            recreationViewHolder = (RecreationViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImgsrc()).into(recreationViewHolder.recreationImgIv);
        recreationViewHolder.recreationTitleTv.setText(datas.get(position).getTitle());
        recreationViewHolder.recreationSortTv.setText(datas.get(position).getSource());
        recreationViewHolder.recreationKindTv.setText(datas.get(position).getReplyCount() + "" + "跟贴");

        return convertView;
    }
    class RecreationViewHolder{
        ImageView recreationImgIv;
        TextView recreationTitleTv;
        TextView recreationSortTv;
        TextView recreationKindTv;

        public RecreationViewHolder(View view){
            recreationImgIv = (ImageView) view.findViewById(R.id.recreation_img);
            recreationTitleTv = (TextView) view.findViewById(R.id.recreation_title_tv);
            recreationSortTv = (TextView) view.findViewById(R.id.recreation_sort_tv);
            recreationKindTv = (TextView) view.findViewById(R.id.recreation_kind_tv);

        }
    }
}
