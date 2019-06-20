package com.cty.filedownload.utills;

import android.text.TextUtils;

import java.security.MessageDigest;

public class Md5Utills {
    public static void main(String args[]){
        System.out.println(generateCode("http://www.imooc.com"));
    }
    public static String generateCode(String url){
        if ("".equals(url)||url==null) {
            return null;
        }
//        if (TextUtils.isEmpty(url)) {
//            return null;
//        }
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest digest=MessageDigest.getInstance("md5");
            digest.update(url.getBytes());
            byte[] cipher = digest.digest();

            for(byte b: cipher){
                String hexStr=(Integer.toHexString(b&0xff));
                buffer.append(hexStr.length()==1?"0"+hexStr:hexStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
