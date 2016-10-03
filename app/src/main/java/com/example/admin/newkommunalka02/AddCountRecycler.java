package com.example.admin.newkommunalka02;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 19.09.2016.
 */
public class AddCountRecycler extends RecyclerView.Adapter<AddCountRecycler.RecyclerViewHolder> {


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        EditText tarif;
        EditText step;
        RecyclerViewHolder(View itemView) {
            super(itemView);
            tarif = (EditText) itemView.findViewById(R.id.recycler_tarif);
            step = (EditText) itemView.findViewById(R.id.recycler_step);
        }
    }
    private List<NewsItem> newsItems = new ArrayList<>();

    public AddCountRecycler(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_count_recycler, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        viewHolder.tarif.setHint(newsItems.get(i).getHeadline());
        viewHolder.step.setHint(newsItems.get(i).getDate());
    }
    @Override
    public int getItemCount() {
        return newsItems == null ? 0 : newsItems.size();
    }
}