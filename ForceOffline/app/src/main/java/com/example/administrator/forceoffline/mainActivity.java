package com.example.administrator.forceoffline;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainActivity extends BassActivity {
    Button offline;
    LocalBroadcastManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        offline = findViewById(R.id.offline);
        manager = LocalBroadcastManager.getInstance(this);
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("offline");
                manager.sendBroadcast(intent);
            }
        });
    }
}
