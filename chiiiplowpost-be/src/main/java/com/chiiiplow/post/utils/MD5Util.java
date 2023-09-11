package com.chiiiplow.post.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * md5加密工具类
 * @author CHIIIPLOW
 * @date 2023/09/11
 */
public class MD5Util {
    private static final String SALT = "chiiiplow";
    // 计算密码的哈希值，包括盐
    public static String hashPassword(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(SALT.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());

            // 将字节数组转换为Base64编码的字符串
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
