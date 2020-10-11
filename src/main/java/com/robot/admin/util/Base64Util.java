package com.robot.admin.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

/**
 * @author robot
 * @date 2020/1/8 10:53
 */
public class Base64Util {

    /**
     * 编码
     *
     * @param str
     * @return
     */
    public static String encode(final String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Base64.encodeBase64String(str.getBytes());
    }

    //重载
    public static String encode(byte[] binaryData) {
        return Base64.encodeBase64String(binaryData);
    }

    /**
     * 解码
     *
     * @param base64
     * @return
     */
    public static String decode(final String base64) {
        if (StringUtils.isEmpty(base64)) {
            return null;
        }
        String str = null;
        str = new String(Base64.decodeBase64(base64), StandardCharsets.UTF_8);
        return str;
    }

    //解码
    public static byte[] decodeBite(String encodedText) {
        byte[] bytes = Base64.decodeBase64(encodedText);

        return bytes;
    }

    //重载
    public static String decode(byte[] binaryData) {
        String str = null;
        str = new String(Base64.decodeBase64(binaryData), StandardCharsets.UTF_8);
        return str;
    }

    /**
     * 判断是否base64过的原文，原理为解密再加密，得到原字符串则代表的是已加密过的
     *
     * @param base64
     * @return
     */
    public static boolean isBase64(final String base64) {
        if (StringUtils.isEmpty(base64)) {
            return false;
        }
        String de = decode(base64);

        String en = encode(de).replaceAll("[\\s*\t\n\r]", "");

        return base64.equals(en);
    }

    //上面的相反判断
    public static boolean isNotBase64(final String base64) {
        return !isBase64(base64);
    }


    //得到一个base64文件的实际大小
    public static long base64file_size(String base64String) {
        //1.获取base64字符串长度(不含data:audio/wav;base64,文件头)
        int size0 = base64String.length();

        //2.获取字符串的尾巴的最后10个字符，用于判断尾巴是否有等号，正常生成的base64文件'等号'不会超过4个
        String tail = base64String.substring(size0 - 10);

        //3.找到等号，把等号也去掉,(等号其实是空的意思,不能算在文件大小里面)
        int equalIndex = tail.indexOf("=");
        if (equalIndex > 0) {
            size0 = size0 - (10 - equalIndex);
        }

        //4.计算后得到的文件流大小，单位为字节
        return size0 - ((long) size0 / 8) * 2;
    }
}
