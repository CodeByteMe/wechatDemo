package org.zj.wechat.service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * Created by poshyed2 on 2017/7/10.
 */
public interface ParseMsgService {
    String replyTextMsg(Map<String,String> map);
    String replyPicMsg(Map<String,String> map);
    String praseMsg(HttpServletRequest request);
}
