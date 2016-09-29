package com.netease.netease.controller.adapter.topicadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.talkbean.TopicBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/20.
 * 话题模块,话题界面适配器
 */
public class TopicAdapter extends BaseAdapter {
    private List<TopicBean.DataBean.SubjectListBean> datas;
    private Context context;
    private LayoutInflater inflater;
    private static final int ITEM_TOPIC = 0;
    private static final int ITEM_IMG = 1;

    public TopicAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<TopicBean.DataBean.SubjectListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    private boolean ifHasData() {
        return datas != null && datas.size() > 0;
    }

    @Override
    public int getCount() {
        return ifHasData() ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return ifHasData() ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 根据position位置获取数据类集合的数据
     * 返回行布局
     */
    public int getItemViewType(int position) {
        int type = datas.get(position).getType();
        if (0 == type) {
            return ITEM_TOPIC;
        } else {
            return ITEM_IMG;
        }
    }
    /**
     * 行布局类型总数
     */
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TopicHolder topicHolder = null;
        ImgHolder imgHolder = null;
        int type = getItemViewType(position);

        if (convertView == null) {
            switch (type) {
                case ITEM_TOPIC:
                    convertView = inflater.inflate(R.layout.item_topic, parent, false);
                    topicHolder = new TopicHolder(convertView);
                    convertView.setTag(topicHolder);
                    break;
                case ITEM_IMG:
                    convertView = inflater.inflate(R.layout.item_topic_img, parent, false);
                    imgHolder = new ImgHolder(convertView);
                    convertView.setTag(imgHolder);
                    break;
            }
        } else {
            switch (type) {
                case ITEM_TOPIC:
                    topicHolder = (TopicHolder) convertView.getTag();
                    break;
                case ITEM_IMG:
                    imgHolder = (ImgHolder) convertView.getTag();
                    break;
            }
        }
        TopicBean.DataBean.SubjectListBean topicBean = datas.get(position);
        switch (type) {
            case ITEM_TOPIC:
                topicHolder.topicTv.setText("#" + topicBean.getName() + "#");
                Log.d("qqq", "------" + datas.get(position).getName());
                topicHolder.contentTv.setText(" " + topicBean.getTalkContent().get(0).getContent());
                topicHolder.oneContentTv.setText(" " + topicBean.getTalkContent().get(1).getContent());
                topicHolder.topicSortTv.setText(topicBean.getClassification());
                topicHolder.topicFollowTv.setText(topicBean.getConcernCount() + "关注");
                topicHolder.topicQuestionTv.setText(topicBean.getTalkCount() + "讨论");
                if (!topicBean.getTalkContent().get(0).getUserHeadPicUrl().isEmpty() && topicBean.getTalkContent().get(0).getUserHeadPicUrl() != null) {
                    Picasso.with(context).load(topicBean.getTalkContent().get(0).getUserHeadPicUrl()).into(topicHolder.suernameIv);
                } else {
                    topicHolder.suernameIv.setImageResource(R.mipmap.a_5);
                }
                if (!topicBean.getTalkContent().get(1).getUserHeadPicUrl().isEmpty() && topicBean.getTalkContent().get(1).getUserHeadPicUrl() != null) {
                    Picasso.with(context).load(topicBean.getTalkContent().get(1).getUserHeadPicUrl()).into(topicHolder.oneSuerNameIv);
                } else {
                    topicHolder.oneSuerNameIv.setImageResource(R.mipmap.a_5);
                }
                break;
            case ITEM_IMG:
                imgHolder.imgTitleTv.setText("#" + topicBean.getName() + "#");
                Picasso.with(context).load(topicBean.getTalkPicture().get(0)).into(imgHolder.oneImgIv);
                Picasso.with(context).load(topicBean.getTalkPicture().get(1)).into(imgHolder.twoImgIv);
                Picasso.with(context).load(topicBean.getTalkPicture().get(2)).into(imgHolder.threeImgIv);
                imgHolder.imgSortTv.setText(topicBean.getClassification());
                imgHolder.imgFollowTv.setText(topicBean.getConcernCount() + "关注");
                imgHolder.imgQuestionIv.setText(topicBean.getTalkCount() + "讨论");
                break;
        }
        return convertView;
    }

    /**
     * 文字帖布局的数据缓存类
     */
    class TopicHolder {
        TextView topicTv;
        ImageView suernameIv, oneSuerNameIv;
        TextView contentTv, oneContentTv;
        TextView topicSortTv, topicFollowTv, topicQuestionTv;

        public TopicHolder(View view) {
            topicTv = (TextView) view.findViewById(R.id.topic_title_tv);
            suernameIv = (CircleImageView) view.findViewById(R.id.topic_username_iv);
            oneSuerNameIv = (CircleImageView) view.findViewById(R.id.topic_username_one_iv);
            oneContentTv = (TextView) view.findViewById(R.id.topic_content_one_tv);
            contentTv = (TextView) view.findViewById(R.id.topic_content_tv);
            topicSortTv = (TextView) view.findViewById(R.id.topic_sort_tv);
            topicFollowTv = (TextView) view.findViewById(R.id.topic_follow_tv);
            topicQuestionTv = (TextView) view.findViewById(R.id.topic_question_tv);
        }

    }
    /**
     * 图片缓存类
     */
    class ImgHolder {
        TextView imgTitleTv;
        ImageView oneImgIv, twoImgIv, threeImgIv;
        TextView imgSortTv, imgFollowTv, imgQuestionIv;

        public ImgHolder(View view) {
            imgTitleTv = (TextView) view.findViewById(R.id.topic_img_title_tv);
            oneImgIv = (ImageView) view.findViewById(R.id.topic_one_img_iv);
            twoImgIv = (ImageView) view.findViewById(R.id.topic_two_img_iv);
            threeImgIv = (ImageView) view.findViewById(R.id.topic_three_img_iv);
            imgSortTv = (TextView) view.findViewById(R.id.topic_sort_img_tv);
            imgFollowTv = (TextView) view.findViewById(R.id.topic_follow_img_tv);
            imgQuestionIv = (TextView) view.findViewById(R.id.topic_question_img_tv);
        }
    }

}
