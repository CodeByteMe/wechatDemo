package org.zj.wechat.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zj.wechat.dao.TextContentDAO;
import org.zj.wechat.entity.TextContent;
import org.zj.wechat.mapper.TextContentMapper;

/**
 * Created by poshyed on 2017/7/10.
 */
@Repository("testMsgDAO")
public class TextContentDAOImpl implements TextContentDAO {
    @Autowired
    TextContentMapper textContentMapper;

    @Override
    public TextContent searchTextMsg(String content) {
        return textContentMapper.getMsg(content);
    }
}
