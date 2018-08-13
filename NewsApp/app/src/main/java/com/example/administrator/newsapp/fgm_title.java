package com.example.administrator.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class fgm_title extends Fragment{
    View view;public List<news> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.title,container,false);
        list.add(new news("123","hvneipourvnvnowepgnojhnogjogjnodbn;dfl;flgjl;gehogjsrpbmpaobniuawegfoaighoinbglkfjwjogegjpnldbnklwgpgipj\njgwogvwinvior\nergvaevbreavbrebvdfbvdfberbe\nevbervbaebertbeb\nearberb"));
        list.add(new news("2534","1"));
        list.add(new news("25334","1j"));
        list.add(new news("234","1d"));
        list.add(new news("23234","1g"));
        list.add(new news("23rw4","1gs"));
        list.add(new news("2dv34","1sg"));
        list.add(new news("2c34","1sfd"));
        list.add(new news("23as4","1fs"));
        list.add(new news("2sd34","1sdf"));
        list.add(new news("23e4","1g"));
        list.add(new news("2t34","f1"));
        list.add(new news("23y4","qwf1"));
        list.add(new news("23s4","1qwf"));
        list.add(new news("23s4","1fq"));
        list.add(new news("23s4","1hdf"));
        list.add(new news("23uy4","dhf1"));
        list.add(new news("23e4","1fq"));
        list.add(new news("23o4","1rg"));
        list.add(new news("23fg4","g1"));
        list.add(new news("234w","1gw"));


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycle_title);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        newsAdapter adapter = new newsAdapter(list);
        recycler.setAdapter(adapter);
    }
}
