package com.example.admin.newkommunalka02;

/**
 * Created by Admin on 16.09.2016.
 */

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    int groupid;
    Activity context;
    ArrayList<SpinnerItem> list;
    LayoutInflater inflater;
    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<SpinnerItem>
            list){
        super(context,id,list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.imageIconSpinner);
        imageView.setImageResource(list.get(position).getImageSpinner());
        TextView textView=(TextView)itemView.findViewById(R.id.textNameSpinner);
        textView.setText(list.get(position).getTextSpinner());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent){
        return getView(position,convertView,parent);

    }
}