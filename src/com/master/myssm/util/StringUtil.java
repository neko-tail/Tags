package com.master.myssm.util;

/**
 * 这是一个字符串工具类
 * @author master
 */
public class StringUtil {
    /**
     * 判断字符串是否为空（null或""）
     * @param str 要判断的字符串
     * @return 是否为空的boolean值
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
