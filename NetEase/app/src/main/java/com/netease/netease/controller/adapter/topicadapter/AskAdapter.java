package com.netease.netease.controller.adapter.topicadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.talkbean.AskBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/18.
 * 问吧界面适配器
 */
public class AskAdapter extends RecyclerView.Adapter<AskAdapter.ViewHolder>{
    private Context context;
    private List<AskBean.DataBean.ExpertListBean> datas;

    public AskAdapter(Context context) {
        this.context = context;
    }


    public void setDatas(List<AskBean.DataBean.ExpertListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ask,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(AskAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getHeadpicurl()).into(holder.titleIv);
        holder.titleTv.setText(datas.get(position).getTitle());
        holder.nameTv.setText(datas.get(position).getName() + " / ");
        Picasso.with(context).load(datas.get(position).getPicurl()).into(holder.centerIv);
        holder.centerTv.setText(datas.get(position).getAlias());
        holder.sortTv.setText(datas.get(position).getClassification());
        holder.followTv.setText(datas.get(position).getConcernCount() + "关注");
        holder.questionTv.setText(datas.get(position).getQuestionCount() + "提问");


    }


    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    //组件缓存类
    //内部类
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView titleIv;
        private TextView titleTv, nameTv;
        private ImageView centerIv;
        private TextView centerTv;
        private TextView sortTv, followTv, questionTv;


        public ViewHolder(View itemView) {
            super(itemView);
            titleIv = (CircleImageView) itemView.findViewById(R.id.ask_title_iv);
            titleTv = (TextView) itemView.findViewById(R.id.ask_title_tv);
            nameTv = (TextView) itemView.findViewById(R.id.ask_name_tv);
            centerIv = (ImageView) itemView.findViewById(R.id.ask_center_iv);
            centerTv = (TextView) itemView.findViewById(R.id.ask_center_tv);
            sortTv = (TextView) itemView.findViewById(R.id.ask_sort_tv);
            followTv = (TextView) itemView.findViewById(R.id.ask_follow_tv);
            questionTv = (TextView) itemView.findViewById(R.id.ask_question_tv);
        }
    }
}
