package org.zj.wechat.mapper;

import org.zj.wechat.entity.TextContent;

/**
 * Created by poshyed on 2017/7/10.
 */
public interface TextContentMapper {
    TextContent getMsg(String content);
}
