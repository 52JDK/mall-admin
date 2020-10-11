package com.robot.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机数生成
 */
public class RandomCodeUtil {


    public static String createPwd() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        String strAll = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.";
        for (int i = 0; i < 16; i++) {
            int index = (int) (Math.random() * 63);
            sb.append(strAll.charAt(index));
        }
        return sb.toString();
    }

    public static String createCode() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成前缀是日期的随机数
     * @return
     */
    public static String getOrderCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String date = sdf.format(new Date());
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        return  date + random;
    }

}
