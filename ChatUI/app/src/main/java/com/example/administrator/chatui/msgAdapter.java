package com.example.administrator.chatui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

public class msgAdapter extends RecyclerView.Adapter<msgAdapter.ViewHolder>{
    private List<mesage> msg;
    public msgAdapter(List<mesage> msg){
        this.msg = msg;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView send;
        TextView received;
        LinearLayout left;
        LinearLayout right;
        public ViewHolder(View view){
            super(view);
            send = view.findViewById(R.id.msgright);
            received = view.findViewById(R.id.msgleft);
            left = view.findViewById(R.id.leftl);
            right = view.findViewById(R.id.rightl);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return msg.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        mesage text = msg.get(i);

        if(text.getMsgType()==mesage.Type_Received){
            viewHolder.right.setVisibility(View.GONE);
            viewHolder.received.setText(text.getText());
        }else if(text.getMsgType() == mesage.Type_Send){
            viewHolder.left.setVisibility(View.GONE);
            viewHolder.send.setText(text.getText());
        }
    }
}
