package com.cty.filedownload.http;

import android.content.Context;

public class HttpManager {
    private static final HttpManager sManager = new HttpManager();
    private Context mContext;


    public static HttpManager getInstance(){
        return sManager;
    }
    private  HttpManager(){

    }
    public void init(Context context){
        this.mContext = context;
    }

    public void syncRequest(String url){

    }

}

