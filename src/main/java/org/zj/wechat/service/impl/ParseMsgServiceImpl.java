package org.zj.wechat.service.impl;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.wechat.dao.TextContentDAO;
import org.zj.wechat.entity.TextContent;
import org.zj.wechat.entity.TextMsg;
import org.zj.wechat.service.ParseMsgService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by poshyed2 on 2017/7/10.
 */
@Service
public class ParseMsgServiceImpl implements ParseMsgService {
    Map<String, String> map = new HashMap<>();
    Set<String> keySet = null;
    @Autowired
    private TextContentDAO textContentDAO;

    @Override
    public String replyTextMsg(Map<String, String> map) {
        String tmpstr = map.get("content");
        TextContent textContent = textContentDAO.searchTextMsg(tmpstr);
        if (textContent != null) {
            TextMsg textMsg = new TextMsg();
            textMsg.setToUserName(map.get("FromUserName"));
            textMsg.setFromUserName(map.get("ToUserName"));
            textMsg.setCreateTime(new Date().getTime());
            textMsg.setMsgType("text");
            textMsg.setContent(textContent.getMsg());
            XStream xStream = new XStream();
            xStream.alias("xml", textMsg.getClass());
            String textMsgXml = xStream.toXML(textMsg);
            return textMsgXml;
        }
        return "request error";
    }

    @Override
    public String replyPicMsg(Map<String, String> map) {
        return null;
    }

    /**
     * 接受inputstream,并解析doc，判别消息类型
     * @param request
     * @return
     */
    @Override
    public String praseMsg(HttpServletRequest request) {
//        利用dom4j解析
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try(InputStream inputStream=request.getInputStream()){
            document = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        keySet = map.keySet();
        if (map.get("MsgType") != null) {
            if (map.get("MsgType").equals("text")) {
                return replyTextMsg(map);
            } else if (map.get("MsgType").equals("image")) {
                return replyPicMsg(map);
            }
        }
        return "request error";
    }
}
