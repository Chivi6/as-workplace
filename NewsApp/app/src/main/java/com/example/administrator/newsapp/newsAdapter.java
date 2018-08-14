package com.example.administrator.newsapp;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.ViewHolder>{
    List<news> news;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.titletext);
        }
    }

    public newsAdapter(List<news> news){
        this.news = news;
    }
    @Override
    public int getItemCount() {
        return news.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.titiletext,null);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                news reflash_news = news.get(holder.getAdapterPosition());
                fgm_content content = (fgm_content) fgm_content.manager.findFragmentById(R.id.fgm_content);
                //fgm_content content = new fgm_content();
                //content = (fgm_content) content.getFragmentManager().findFragmentById(R.id.fgm_content);
                content.reflash(reflash_news.getTitle(),reflash_news.getContent());
            }
        });
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        news newtitlt = news.get(i);
        viewHolder.textView.setText(newtitlt.getTitle());
    }
}
