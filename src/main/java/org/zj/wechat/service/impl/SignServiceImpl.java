package org.zj.wechat.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zj.wechat.service.SignService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by poshyed2 on 2017/7/10.
 */
@Service
public class SignServiceImpl implements SignService {
    private static final String TOKEN = "poshyeddewechat";

    /**
     * 组合参数，验证签名
     *
     * @param signature:加密签名
     * @param timestamp:时间戳
     * @param nonce：随机数
     */
    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] signatureArr = new String[]{TOKEN, timestamp, nonce};
//        将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(signatureArr);
//        将三个字符串拼接成一个字符串
        StringBuilder content = new StringBuilder();
        for (String s : signatureArr) {
            content.append(s);
        }
        String tmpStr = null;
//        进行sha1加密
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(content.toString().getBytes());
            tmpStr = byteToHexStr(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//        对比signature
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 字节转十六进制字符串
     *
     * @param mByte
     * @return
     */
    @Override
    public String byteToHexStr(byte[] mByte) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int len = mByte.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(digit[(mByte[j] >> 4) & 0x0f]);
            buf.append(digit[mByte[j] & 0x0f]);
        }
        return buf.toString();
    }
}
