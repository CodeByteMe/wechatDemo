package org.zj.wechat.controller;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zj.wechat.service.ParseMsgService;
import org.zj.wechat.service.SignService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by poshyed2 on 2017/7/10.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(WechatController.class);
    @Autowired
    SignService signService;

    /**
     * 接受get参数，验证登录
     *
     * @param request
     * @param response
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @RequestMapping(value = "/security", method = RequestMethod.GET)
    @ResponseBody
    public void userCheck(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(value = "signature") String signature,
                          @RequestParam(value = "timestamp") String timestamp,
                          @RequestParam(value = "nonce") String nonce,
                          @RequestParam(value = "echostr") String echostr) {
        try (PrintWriter printWriter = response.getWriter()) {

            if (signService.checkSignature(signature, timestamp, nonce)) {
                LOGGER.info("Connect the weixin server is successful.");
                printWriter.write(echostr);
            } else {
                LOGGER.info("Failed to verify the signature!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接受微信发送的post消息
     *
     * @param request
     * @param response
     */
    @Autowired
    ParseMsgService parseMsgService;

    @RequestMapping(value = "/security", method = RequestMethod.POST)
    public void receiveMessage(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter printWriter = response.getWriter()) {
            String msg = parseMsgService.praseMsg(request);
            if (msg != null && msg.equals("request error")) {
                LOGGER.info("request success");
                printWriter.write(msg);
            } else {
                LOGGER.info("request error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
