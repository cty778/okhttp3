package com.cty.okhttp3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cty.filedownload.file.FileStorageManager;
import com.cty.filedownload.utills.Logger;

import java.io.File;

public class MyApplication extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FileStorageManager.getInstance().init(this);
        File file = FileStorageManager.getInstance().getFileByName("http://www.imooc.com");
        Logger.debug("name","file path="+file.getAbsoluteFile());
    }
}
