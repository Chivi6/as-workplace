package com.example.administrator.httpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send = findViewById(R.id.sendquest);
        text = findViewById(R.id.text);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("172.16.12.200",8088);
                            PrintStream printStream = new PrintStream(socket.getOutputStream());
                            printStream.print("nihao");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            StringBuilder stringBuilder = new StringBuilder();
                            String line;
                            while ((line=reader.readLine())!=null){
                                // Log.d("what",line);
                                stringBuilder.append(line);
                            }
                            show(stringBuilder.toString());
                            socket.close();
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        /*HttpURLConnection connection = null;
                        BufferedReader reader = null;
                        try {
                            URL url = new URL("http://172.16.12.200:8088");
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setReadTimeout(8000);
                            connection.setConnectTimeout(8000);
                            InputStream in = connection.getInputStream();
                            reader = new BufferedReader(new InputStreamReader(in));
                            StringBuilder stringBuilder = new StringBuilder();
                            String line;
                            while ((line=reader.readLine())!=null){
                                //Log.d("what",line);
                                stringBuilder.append(line);
                            }
                            show(stringBuilder.toString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            if (reader!=null){
                                try {
                                    reader.close();
                                    Log.d("reader","close");
                                }catch (IOException io){
                                    io.printStackTrace();
                                }
                                if (connection!=null){
                                    connection.disconnect();
                                    Log.d("conection","close");
                                }
                            }
                        }*/
                    }
                }).start();

            }
        });
    }
    private void show (final String str){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(str);
            }
        });
    }
}
