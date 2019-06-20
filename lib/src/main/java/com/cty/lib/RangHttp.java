package com.cty.lib;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.Header;

public class RangHttp {
    public static void main(String args[]){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://edbspyxgs.cn/uploadfile/63063_20160428145948.jpg").addHeader("Range","bytes=0-2").build();


        try{
            Response response =client.newCall(request).execute();
            System.out.println("content-length:"+response.body().contentLength());
            if (response.isSuccessful()){
                Headers headers = response.headers();
                for(int i=0;i<headers.size();i++){
                    System.out.println(headers.name(i)+":" + headers.value(i));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
