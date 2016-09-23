package com.netease.netease.controller.adapter.onlineadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.onlinebean.OnlineClassifyBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 直播模块,分类界面的适配器
 */
public class ClassifyAdapter extends BaseAdapter{
    private Context context;
    private List<OnlineClassifyBean.LiveReviewBean> datas;

    public ClassifyAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<OnlineClassifyBean.LiveReviewBean> datas) {
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
        ClassifyViewHolder classifyViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_online_classify,parent,false);
            classifyViewHolder = new ClassifyViewHolder(convertView);
            convertView.setTag(classifyViewHolder);
        }else {
            classifyViewHolder = (ClassifyViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(datas.get(position).getImage()).into(classifyViewHolder.classifyTitleIv);
        classifyViewHolder.classifyTitleTv.setText(datas.get(position).getRoomName());
        classifyViewHolder.classifyAction.setText(datas.get(position).getUserCount() + "参与");

        /**
         * 图标显示直播,回顾.提醒出进行判断,例如:video为ture,mutilvideo为false,liveStatus为1,
         * 这调用本地图标在界面中显示直播中图标.以此类推.
         */
        if ((datas.get(position).isVideo() == true && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 1)){
            classifyViewHolder.classifyImgIv.setImageResource(R.mipmap.a5x);
        } else if ((datas.get(position).isVideo() == false && datas.get(position).isMutilVideo() == false && datas.get(position).getLiveStatus() == 0)){
            classifyViewHolder.classifyImgIv.setImageResource(R.mipmap.a5u);
        }else if ((datas.get(position).isVideo() == true && datas.get(position).isMutilVideo() == false&& datas.get(position).getLiveStatus() == 2)){
            classifyViewHolder.classifyImgIv.setImageResource(R.mipmap.a60);
        }else if ((datas.get(position).isVideo() == false && datas.get(position).isMutilVideo() == false&& datas.get(position).getLiveStatus() == 2)){
            classifyViewHolder.classifyImgIv.setImageResource(R.mipmap.a5z);
        }

        return convertView;
    }
    class ClassifyViewHolder{
        ImageView classifyTitleIv;
        TextView classifyTitleTv;
        ImageView classifyImgIv;
        TextView classifyAction;
        public ClassifyViewHolder(View view){
            classifyTitleIv = (ImageView) view.findViewById(R.id.online_classify_title_iv);
            classifyTitleTv = (TextView) view.findViewById(R.id.online_classify_title_tv);
            classifyImgIv = (ImageView) view.findViewById(R.id.online_classify_img_iv);
            classifyAction = (TextView) view.findViewById(R.id.online_classify_action_tv);
        }

    }
}
