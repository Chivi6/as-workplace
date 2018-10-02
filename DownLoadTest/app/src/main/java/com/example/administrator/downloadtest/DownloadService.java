package com.example.administrator.downloadtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.io.File;

public class DownloadService extends Service {

    private DownloadTask downloadTask;
    private String downloadURL;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
                getNtfctM().notify(1,getNotification("Downloading",progress));
        }

        @Override
        public void onSuccess() {
                downloadTask = null;
                stopForeground(true);
                getNtfctM().notify(1,getNotification("Download Success",-1));
                Toast.makeText(DownloadService.this,"Download Success",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downloadTask = null;
            stopForeground(true);
            getNtfctM().notify(1,getNotification("Download Failed",-1));
            Toast.makeText(DownloadService.this,"Download Failed",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downloadTask = null;

            Toast.makeText(DownloadService.this,"Download Paused",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downloadTask = null;
            stopForeground(true);
            Toast.makeText(DownloadService.this,"Download Canceled",Toast.LENGTH_SHORT).show();
        }
    };
    public DownloadService() {
    }
    private DownloadBinder mbinder = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(String url){
            if (downloadTask == null){
                downloadURL = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadURL);
                startForeground(1,getNotification("Downloading",0));
                Toast.makeText(DownloadService.this,"Download",Toast.LENGTH_SHORT).show();
            }
        }

        public void pauseDownload(){
            if (downloadTask!=null){
                downloadTask.pasueDownload();
            }
        }

        public void cancelDownload(){
            if (downloadTask!=null){
                downloadTask.cancelDownload();
            }else {
                if (downloadURL!=null){
                    String fileName = downloadURL.substring(downloadURL.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(directory+fileName);
                    if (file.exists()){
                        file.delete();
                    }
                    getNtfctM().cancel(1);
                    stopForeground(true);
                    Toast.makeText(DownloadService.this,"Canceled",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    private NotificationManager getNtfctM(){
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    private Notification getNotification(String title,int progress){
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setContentTitle(title);
        if (progress > 0){
            builder.setContentText(progress+"%")
                    .setProgress(100,progress,false);
        }
        return builder.build();
    }
}
