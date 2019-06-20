package com.cty.lib;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CacheHttp {
    public static void main(String args[]) throws IOException {
        int maxCacheSize = 10 *1024 * 1024;

        Cache cache = new Cache(new File("C:\\Users\\Administrator\\Desktop\\qq"),maxCacheSize);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
//        Request request = new Request.Builder().url("http://www.qq.com/").build();
        Request request = new Request.Builder().url("http://www.qq.com/").cacheControl(new CacheControl.Builder().noCache().build()).build();
        Response response = client.newCall(request).execute();

        String body1 = response.body().string();

        try {
            System.out.println("network response:"+ response.networkResponse());
            System.out.println("cache response:"+ response.cacheResponse());
            System.out.println("************************");
            Response response1 = client.newCall(request).execute();
            String body2 = response1.body().string();
            System.out.println("network response:"+ response1.networkResponse());
            System.out.println("cache response:"+ response1.cacheResponse());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
