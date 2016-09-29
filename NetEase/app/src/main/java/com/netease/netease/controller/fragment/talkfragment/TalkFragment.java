package com.netease.netease.controller.fragment.talkfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.topicadapter.TalkAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题模块fragment
 */
public class TalkFragment extends AbsBaseFragment {
    private TalkAdapter talkAdapter;
    private TabLayout talkTl;
    private ViewPager talkVp;
    private List<Fragment> talkdatas;
    @Override
    protected int setLayout() {
        return R.layout.fragment_talk;
    }

    @Override
    protected void initViews() {
        talkTl = findView(R.id.talk_tab_layout);
        talkVp = findView(R.id.talk_view_pager);

    }

    @Override
    protected void initDatas() {
        talkdatas = new ArrayList<>();
        talkdatas.add(new AskFragment());
        talkdatas.add(new TopicFragment());
        talkdatas.add(new FollowFragment());


        talkAdapter = new TalkAdapter(getChildFragmentManager(), talkdatas);
        talkVp.setAdapter(talkAdapter);

        talkTl.setupWithViewPager(talkVp);
        talkTl.setTabMode(TabLayout.MODE_SCROLLABLE);
       String [] talktitle = {"问吧", "话题", "关注"};
        for (int i = 0; i < 3; i++) {
            talkTl.getTabAt(i).setText(talktitle[i]);
        }
    }
}
