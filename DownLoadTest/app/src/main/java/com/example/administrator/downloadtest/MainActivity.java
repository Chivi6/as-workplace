package com.example.administrator.downloadtest;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DownloadService.DownloadBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startDL = findViewById(R.id.startDL);
        Button pauseDL = findViewById(R.id.pauseDL);
        Button cancelDL = findViewById(R.id.cancelDL);
        Intent intent = new Intent(MainActivity.this,DownloadService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        startDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binder==null){
                    return;
                }
                binder.startDownload("https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe");
            }
        });
        pauseDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binder==null){
                    return;
                }
                binder.pauseDownload();
            }
        });
        cancelDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binder==null){
                    return;
                }
                binder.cancelDownload();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==1){
            if (grantResults.length>0 && grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"权限不够",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
