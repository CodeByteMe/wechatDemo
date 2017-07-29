package org.zj.wechat.entity;

/**
 * Created by poshyed2 on 2017/7/10.
 */
public class PicMsg {
    /**
     * 根据官方文档，建立文字消息实体
     */
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String PicUrl;

    public PicMsg(String toUserName, String fromUserName, String createTime, String msgType, String picUrl) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        PicUrl = picUrl;
    }

    @Override
    public String toString() {
        return "PicMsg{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                '}';
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
