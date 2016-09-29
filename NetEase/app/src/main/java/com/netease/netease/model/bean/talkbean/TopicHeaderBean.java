package com.netease.netease.model.bean.talkbean;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 话题界面头布局实体类
 */
public class TopicHeaderBean {

    /**
     * focusNum : 823
     * picUrl : http://dingyue.nosdn.127.net/cSoDr2l2nzx1Wo2Z77035FD6LNMNS58Z=UZ42Q2nPlOFE1462263101594.jpg
     * topicId : SJ6799548093180300617
     * topicName : 孙俪
     */

    private List<话题Bean> 话题;

    public List<话题Bean> get话题() {
        return 话题;
    }

    public void set话题(List<话题Bean> 话题) {
        this.话题 = 话题;
    }

    public static class 话题Bean {
        private int focusNum;
        private String picUrl;
        private String topicId;
        private String topicName;

        public int getFocusNum() {
            return focusNum;
        }

        public void setFocusNum(int focusNum) {
            this.focusNum = focusNum;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }
}
