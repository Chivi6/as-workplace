package com.example.administrator.forceoffline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends BassActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    CheckBox checkBox;
    Button login ;
    EditText account;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("account",MODE_PRIVATE);
        checkBox = findViewById(R.id.rememberpsw);
        login =  findViewById(R.id.login);
        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        if (sp.getBoolean("isRemember",false)){
            account.setText(sp.getString("account",""));
            password.setText(sp.getString("password",""));
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accstr = account.getText().toString();
                String pswstr = password.getText().toString();
                if (accstr.equals("123")&&pswstr.equals("123")){
                    editor = sp.edit();
                    if (checkBox.isChecked()){
                        editor.putBoolean("isRemember",true);
                        editor.putString("account",accstr);
                        editor.putString("password",pswstr);
                    }else {
                        editor.putBoolean("isRemember",false);
                    }
                    editor.apply();
                    Intent intent = new Intent(Login.this,mainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
