package com.netease.netease.controller.adapter.topicadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.talkbean.TopicHeaderBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 话题模块,话题界面头布局适配器
 */
public class TopicHeaderAdapter extends RecyclerView.Adapter<TopicHeaderAdapter.HeaderViewHolder> {
    private Context context;
    private List<TopicHeaderBean.话题Bean> datas;

    public TopicHeaderAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<TopicHeaderBean.话题Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public HeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic_header, parent, false);
        HeaderViewHolder holder = new HeaderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HeaderViewHolder holder, int position) {
        holder.headerTv.setText("#" + datas.get(position).getTopicName() + "#");
        Picasso.with(context).load(datas.get(position).getPicUrl()).into(holder.headerIv);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView headerIv;
        TextView headerTv;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerIv = (ImageView) itemView.findViewById(R.id.topic_header_iv);
            headerTv = (TextView) itemView.findViewById(R.id.topic_header_tv);
        }
    }
}
