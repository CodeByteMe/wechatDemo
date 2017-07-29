package org.zj.wechat.service;

/**
 * Created by poshyed2 on 2017/7/10.
 */
public interface SignService {
    boolean checkSignature(String signature, String timestamp, String nonce);
    String byteToHexStr(byte[] mByte);
}
