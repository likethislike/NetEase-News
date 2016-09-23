package com.netease.netease.controller.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.RotateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class RotateVpAdapter<V> extends PagerAdapter{
    private List<RotateBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public RotateVpAdapter(List<RotateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public RotateVpAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<RotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        //为了让ViewPager到最后一页不会像翻书一样回到第一页,设置int为最大值
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_rotate,container,false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_rotate_iv);
        TextView textView = (TextView) convertView.findViewById(R.id.item_rotate_tv);
        textView.setText("文字内容" + newPosition);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
