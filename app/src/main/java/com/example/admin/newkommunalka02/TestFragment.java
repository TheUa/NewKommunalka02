package com.example.admin.newkommunalka02;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 21.08.2016.
 */
public class TestFragment extends android.app.Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        setHasOptionsMenu(true);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View rootView = inflater.inflate(R.layout.test, container, false);
        return rootView;
    }
}
