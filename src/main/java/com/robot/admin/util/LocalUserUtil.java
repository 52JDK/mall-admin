package com.robot.admin.util;


public class LocalUserUtil {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setUid(String uid) {
        threadLocal.set(uid);
    }

    public static String getUid() {
        return threadLocal.get();
    }

    public static void deleteUid() {
        threadLocal.remove();
    }
}
