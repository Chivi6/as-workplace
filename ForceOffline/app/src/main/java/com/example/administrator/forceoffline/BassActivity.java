package com.example.administrator.forceoffline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BassActivity extends AppCompatActivity {
    private Receiver receiver;
    LocalBroadcastManager manager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityList.add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        manager = LocalBroadcastManager.getInstance(this);
        filter.addAction("offline");
        receiver = new Receiver();
        manager.registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityList.remove(this);
    }

    public class Receiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(BassActivity.this);
            builder.setTitle("警告");
            builder.setMessage("你已经登出");
            builder.setCancelable(false);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityList.finishAll();
                    Intent in = new Intent(context,Login.class);
                    startActivity(in);
                }
            });
            builder.show();
        }
    }
}

