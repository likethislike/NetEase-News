package com.netease.netease.model.bean.newsbean;


import com.squareup.picasso.RequestCreator;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻娱乐界面数据实体类
 */
public class NewsRecreationBean {

    /**
     * postid : PHOTIL0S000300AJ
     * hasCover : false
     * hasHead : 1
     * replyCount : 6114
     * hasImg : 1
     * digest :
     * hasIcon : true
     * docid : 9IG74V5H00963VRO_C1JA3FKIbjjinshuupdateDoc
     * title : 张铁林夺子画面曝光 谈判时伸手怒指女方
     * order : 1
     * priority : 250
     * lmodify : 2016-09-22 18:22:25
     * boardid : ent2_bbs
     * ads : [{"title":"敢穿我只服金大姐！金卡戴珊透视装出街","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/35d13c7f1cdb485eb7b25a29d5e71bb820160910102629.jpeg","subtitle":"","url":"00AJ0003|610122"}]
     * photosetID : 00AJ0003|611356
     * template : normal1
     * votecount : 5870
     * skipID : 00AJ0003|611356
     * alias : Entertainment
     * skipType : photoset
     * cid : C1348648351901
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/65e48f2b2153460f9f1e88fcd53648ac20160922182218.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/9f35f5c082454bcd90e9adcb6922c2a220160922182219.jpeg"}]
     * source : 网易原创
     * ename : yule
     * imgsrc : http://cms-bucket.nosdn.127.net/94b4fd54a8264ae3a2bce0206cc3c04220160922180512.jpeg
     * tname : 娱乐
     * ptime : 2016-09-22 18:05:36
     */

    private List<T1348648517839Bean> T1348648517839;

    public List<T1348648517839Bean> getT1348648517839() {
        return T1348648517839;
    }

    public void setT1348648517839(List<T1348648517839Bean> T1348648517839) {
        this.T1348648517839 = T1348648517839;
    }

    public static class T1348648517839Bean {
        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String imgsrc;
        private String tname;
        private String ptime;
        /**
         * title : 敢穿我只服金大姐！金卡戴珊透视装出街
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/35d13c7f1cdb485eb7b25a29d5e71bb820160910102629.jpeg
         * subtitle :
         * url : 00AJ0003|610122
         */

        private List<AdsBean> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/65e48f2b2153460f9f1e88fcd53648ac20160922182218.jpeg
         */

        private List<ImgextraBean> imgextra;

        public T1348648517839Bean(RequestCreator load) {

        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsBean {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
