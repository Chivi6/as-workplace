package com.example.administrator.chatui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; 

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<mesage> msg=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recycler = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        setMsg();
        final msgAdapter adapter = new msgAdapter(msg);
        recycler.setAdapter(adapter);
        final TextView sendText = findViewById(R.id.edittext);
        Button send = findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = sendText.getText().toString();
                if(!text.equals("")){
                    mesage newmsg=new mesage(text,mesage.Type_Send);
                    msg.add(newmsg);
                    adapter.notifyItemInserted(msg.size()-1);
                    recycler.scrollToPosition(msg.size()-1);
                    sendText.setText("");
                }
                Log.d("msg:",msg.get(msg.size()-1).getText());
            }
        });
    }
    private void setMsg(){
        msg.add(new mesage("hollowrold",mesage.Type_Received));
    }
}
