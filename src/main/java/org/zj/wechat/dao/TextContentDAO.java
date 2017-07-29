package org.zj.wechat.dao;

import org.zj.wechat.entity.TextContent;
import org.zj.wechat.entity.TextMsg;

/**
 * Created by poshyed2 on 2017/7/10.
 */
public interface TextContentDAO {
    TextContent searchTextMsg(String content);
}
