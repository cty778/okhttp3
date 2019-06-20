package com.cty.lib;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MultipartHttp {
    public static void main(String args[]){
        RequestBody imageBody = RequestBody.create(MediaType.parse("image/jpeg"),new File("/Users/name/girl.jpg"));
        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("name","name").addFormDataPart("filename","girl.jpg",null).build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://192.198.0.241:8080/web/UploadServlet").post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
