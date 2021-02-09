package com.aditya.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    int list[] ;
    Context context;

    public SliderAdapter(int[] list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SliderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.ViewHolder holder, int position) {
            holder.view.setBackgroundColor(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View view;

        public ViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            ctx = context;
            view = itemView.findViewById(R.id.view);
        }
    }
}
