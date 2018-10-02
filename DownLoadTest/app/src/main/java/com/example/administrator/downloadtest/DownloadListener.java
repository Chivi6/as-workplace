package com.example.administrator.downloadtest;

public interface DownloadListener {
    void  onProgress(int progress);
    void onSuccess();
    void  onFailed();
    void  onPaused();
    void  onCanceled();
}
