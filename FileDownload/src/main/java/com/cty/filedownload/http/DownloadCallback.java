package com.cty.filedownload.http;

import java.io.File;

public interface DownloadCallback {
    void success(File file);
    void fall(int errorCode,String errorMessage);
    void Progress(int progress);
}
