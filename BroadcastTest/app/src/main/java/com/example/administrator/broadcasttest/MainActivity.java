package com.example.administrator.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //NetWorkChangeReceiver receiver;
    MyBroadcstReceiver receiver;
    IntentFilter intentFilter;
    LocalBroadcastManager broadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        TextView textView = findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("mybroadcast");
                broadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        receiver = new MyBroadcstReceiver();
        intentFilter.addAction("mybroadcast");
        broadcastManager.registerReceiver(receiver,intentFilter);
    /*    intentFilter = new IntentFilter();
        receiver = new NetWorkChangeReceiver();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    class  NetWorkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null&&info.isConnected()){
                Toast.makeText(context,"conneted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "disconneted", Toast.LENGTH_SHORT).show();
            }
        }*/
    }
}
