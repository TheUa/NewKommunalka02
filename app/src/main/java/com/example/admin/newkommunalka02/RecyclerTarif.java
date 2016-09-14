package com.example.admin.newkommunalka02;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.01.2016.
 */
public class RecyclerTarif extends RecyclerView.Adapter<RecyclerTarif.RecyclerViewHolder> {

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView archive_count;
        TextView archive_date;
        TextView archive_summ;
        TextView archive_descr;
        TextView archive_id;
        RecyclerViewHolder(View itemView) {
            super(itemView);
            archive_count = (TextView) itemView.findViewById(R.id.archive_count);
            archive_date = (TextView) itemView.findViewById(R.id.archive_date);
            archive_summ = (TextView) itemView.findViewById(R.id.archive_summ);
            archive_descr = (TextView) itemView.findViewById(R.id.archive_description);
            archive_id = (TextView) itemView.findViewById(R.id.id);
        }
    }
private List<ArchiveItem> archiveItems = new ArrayList<>();

    public RecyclerTarif(List<ArchiveItem> archiveItems) {
        this.archiveItems = archiveItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tarif_recycler_item, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        viewHolder.archive_count.setText(archiveItems.get(i).getArchiveCount());
        viewHolder.archive_date.setText(archiveItems.get(i).getArchiveDate());
        viewHolder.archive_summ.setText(archiveItems.get(i).getArchiveTime());
        viewHolder.archive_descr.setText(archiveItems.get(i).getArchiveDescr());
        viewHolder.archive_id.setText(Integer.toString(archiveItems.get(i).getArchiveId()));
    }
    @Override
    public int getItemCount() {
        return archiveItems == null ? 0 : archiveItems.size();
    }
}


