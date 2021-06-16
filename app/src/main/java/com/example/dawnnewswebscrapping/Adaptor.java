package com.example.dawnnewswebscrapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder> {
    private ArrayList<ParseItem> listData;
    Context context;

    public Adaptor(ArrayList<ParseItem> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParseItem ld=listData.get(position);
        holder.title.setText(ld.getTitle());
        holder.authername.setText(ld.getAuthername());
        holder.description.setText(ld.getDescription());
        Glide.with(context).load(ld.getImgUrl()).centerCrop().into(holder.autherimage);
        holder.time.setText(ld.getTime());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,authername,description,time;
        ImageView autherimage;
        public ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            authername=(TextView)itemView.findViewById(R.id.authername);
            description=(TextView)itemView.findViewById(R.id.description);
            autherimage = (ImageView) itemView.findViewById(R.id.img);
            time= (TextView)itemView.findViewById(R.id.txttime);
        }
    }
}
