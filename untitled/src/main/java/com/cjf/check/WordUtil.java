package com.cjf.check;

import java.io.UnsupportedEncodingException;

/**
 * @author junfu
 * @description
 * @date 2021/9/19 0:00
 */
public class WordUtil{
    public static boolean isChineseCharacter(char ch) {
        // 判断是否汉字
        return (ch >= 0x4E00 && ch <= 0x9FA5);

    }

    /**
     * 根据输入的Unicode字符，获取它的GB2312编码或者ascii编码，
     *
     * @param ch
     *            输入的GB2312中文字符或者ASCII字符(128个)
     * @return ch在GB2312中的位置，-1表示该字符不认识
     */
    public static short getGB2312Code(char ch) {
        try {
            byte[] buffer = Character.toString(ch).getBytes("GB2312");
            if (buffer.length != 2) {
                // 正常情况下buffer应该是两个字节，否则说明ch不属于GB2312编码，故返回'?'，此时说明不认识该字符
                return -1;
            }
            // 编码从A1开始，因此减去0xA1=161
            int b0 = (int) (buffer[0] & 0x0FF) - 161;
            // 第一个字符和最后一个字符没有汉字，因此每个区只收16*6-2=94个汉字
            int b1 = (int) (buffer[1] & 0x0FF) - 161;
            return (short) (b0 * 94 + b1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
