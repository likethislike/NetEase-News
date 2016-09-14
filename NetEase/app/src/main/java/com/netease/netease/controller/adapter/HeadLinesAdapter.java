package com.netease.netease.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.NewsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/13.
 *
 */
public class HeadLinesAdapter extends BaseAdapter{
    private Context context;
    private List<NewsBean.T1467284926140Bean> datas;

    public HeadLinesAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsBean.T1467284926140Bean> datas) {
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
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_headline,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewsBean.T1467284926140Bean bean = datas.get(position);
        if (bean != null){
            holder.titleTv.setText(bean.getTitle());
            holder.showTv.setText(bean.getSource());
            holder.styleTv.setText(bean.getReplyCount() + "跟贴");
            //网络图片框架.通过context加载图片网址
            Picasso.with(context).load(bean.getImgsrc()).into(holder.pictureIv);

        }
        return convertView;
    }
    private class ViewHolder{
        ImageView pictureIv;
        TextView titleTv;
        TextView showTv;
        TextView styleTv;
        public ViewHolder(View view){
            pictureIv = (ImageView) view.findViewById(R.id.item_picture);
            titleTv = (TextView) view.findViewById(R.id.item_title);
            showTv = (TextView) view.findViewById(R.id.item_show);
            styleTv = (TextView) view.findViewById(R.id.item_style);
        }
    }
}
