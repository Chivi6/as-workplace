package com.example.administrator.filepersistencetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit);
        String str = load();
        if (!TextUtils.isEmpty(str)){
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(editText.getText().toString());
    }

    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        return  content.toString();
    }

    public void save(String str){
        FileOutputStream out=null;
        BufferedWriter buffer=null;
        try {
            out = openFileOutput("data", MODE_PRIVATE);
            buffer = new BufferedWriter(new OutputStreamWriter(out));
            buffer.write(str);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try{
                if (buffer!=null){
                    buffer.close();
                }
            }catch (IOException  ioe){
                ioe.printStackTrace();
            }
        }
    }
}
