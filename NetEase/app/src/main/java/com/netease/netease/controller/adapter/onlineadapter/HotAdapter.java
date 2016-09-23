package com.netease.netease.controller.adapter.onlineadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.onlinebean.OnlineHotBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 直播模块,热门界面适配器
 */
public class HotAdapter extends BaseAdapter {
    private Context context;
    private List<OnlineHotBean.LiveReviewBean> datas;

    public HotAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<OnlineHotBean.LiveReviewBean> datas) {
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
        HotViewHolder hotViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_online_hot, parent, false);
            hotViewHolder = new HotViewHolder(convertView);
            convertView.setTag(hotViewHolder);
        } else {
            hotViewHolder = (HotViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImage()).into(hotViewHolder.hotTitleIv);
        hotViewHolder.hotTitleTv.setText(datas.get(position).getRoomName());
        hotViewHolder.hotAction.setText(datas.get(position).getUserCount() + "参与");
        /**
         * 在视频模块界面中显示直播中,直播,回顾直播中,回顾进行判断
         * 例如:video为ture,mutilvideo为ture,livestatus等于1的时候,显示正在直播图标;依次类推
         * 此界面与直播模块,分类界面判断相同
         */
        if ((datas.get(position).isVideo() == true && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 1)) {
            hotViewHolder.hotImgIv.setImageResource(R.mipmap.a5x);
        } else if ((datas.get(position).isVideo() == false && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 1)) {
            hotViewHolder.hotImgIv.setImageResource(R.mipmap.a5w);
        } else if ((datas.get(position).isVideo() == true && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 2)) {
            hotViewHolder.hotImgIv.setImageResource(R.mipmap.a60);
        } else if ((datas.get(position).isVideo() == false && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 2)) {
            hotViewHolder.hotImgIv.setImageResource(R.mipmap.a5z);
        }

        return convertView;
    }

    class HotViewHolder {
        ImageView hotTitleIv;
        TextView hotTitleTv;
        ImageView hotImgIv;
        TextView hotAction;

        public HotViewHolder(View view) {
            hotTitleIv = (ImageView) view.findViewById(R.id.online_hot_title_iv);
            hotTitleTv = (TextView) view.findViewById(R.id.online_hot_title_tv);
            hotImgIv = (ImageView) view.findViewById(R.id.online_hot_img_iv);
            hotAction = (TextView) view.findViewById(R.id.online_hot_action_tv);
        }

    }
}
