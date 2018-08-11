package com.example.administrator.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder>{
    private List<image> imgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView picName;
        public ViewHolder(View view){
            super(view);
            pic = (ImageView) view.findViewById(R.id.pic);
            picName = (TextView) view.findViewById(R.id.pic_name);
        }
    }
    public imageAdapter(List<image> list){
        imgList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        image img = imgList.get(i);
        viewHolder.picName.setText(img.getName());
        viewHolder.pic.setImageResource(img.getImgNumber());
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }
}
