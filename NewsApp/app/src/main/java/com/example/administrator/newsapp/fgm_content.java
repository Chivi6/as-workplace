package com.example.administrator.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fgm_content extends Fragment {
    View view;
    public static FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.content,container,false);
        return view;
    }
    public void reflash(String title,String content){
        TextView textView = view.findViewById(R.id.content_title);
        TextView textView1 = view.findViewById(R.id.content);
        textView.setText(title);
        textView1.setText(content);
        Log.d("reflash","OK?");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = getFragmentManager();
    }
}
