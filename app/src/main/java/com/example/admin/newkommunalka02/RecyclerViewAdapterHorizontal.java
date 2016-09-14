package com.example.admin.newkommunalka02;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20.08.2016.
 */
public class RecyclerViewAdapterHorizontal extends RecyclerView.Adapter<RecyclerViewAdapterHorizontal.RecyclerViewHolder> {


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView vertical_headline;
        ImageView image;
        RecyclerViewHolder(View itemView) {
            super(itemView);
            vertical_headline = (TextView) itemView.findViewById(R.id.counter_text);
            image = (ImageView) itemView.findViewById(R.id.counter_main);
        }
    }
    private List<NewsItem> newsItems = new ArrayList<>();
    private int mRowIndex = -1;


    public RecyclerViewAdapterHorizontal(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_recycler_horizontal_item, viewGroup, false);
        return new RecyclerViewHolder(v);
    }
//
//    @Override
//    public void onViewDetachedFromWindow(RecyclerViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        holder.itemView.clearAnimation();
//    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        viewHolder.vertical_headline.setText(newsItems.get(i).getHeadline());
        viewHolder.image.setImageResource(newsItems.get(i).getImageUrl());
    }
    @Override
    public int getItemCount() {
        return newsItems == null ? 0 : newsItems.size();
    }


}
