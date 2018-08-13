package com.example.administrator.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fgm = new ArrayList<>();
    int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fgm.add(new rFrag());
        fgm.add(new rightfgm2());
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == 0){
                    replacefgm(fgm.get(state));
                    state = 1;
                }else if (state == 1){
                    replacefgm(fgm.get(state));
                    state = 0;
                }else {
                    state = 0;
                }
            }
        });
    }
    private  void replacefgm(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rightfgm,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
