package com.wzk.util;

import java.security.MessageDigest;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO SHA-512 加密工具类 调用encode()对传入字符串加密
 * @date 2020/12/4 17:06
 */
public class SHA {
    private  final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * description: 将SHA加密后的密文转为十六进制的字符串类型。
     * TODO:
     * date         2020/12/4 17:18
     * @author      DanRan233
     * @Param       [bytes]
     * @return      java.lang.String
     */
    private  String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * description: 对传入字符串使用SHA-512加密
     * TODO:
     * date         2020/12/4 17:19
     * @author      DanRan233
     * @Param
     * @return
     */
    public  String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            // 参数值为SHA-1、SHA-256、SHA-384、SHA-512,分别对应四种加密方式
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
