package org.zj.wechat.entity;

/**
 * Created by poshyed2 on 2017/7/10.
 */
public class TextMsg {
    /**
     * 根据官方文档，建立文字消息实体
     */
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private String content;

    @Override
    public String toString() {
        return "TextMsg{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", content='" + content + '\'' +
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

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
