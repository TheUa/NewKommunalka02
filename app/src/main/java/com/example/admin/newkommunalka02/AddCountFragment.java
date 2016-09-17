package com.example.admin.newkommunalka02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.function.ToLongBiFunction;

/**
 * Created by Admin on 16.09.2016.
 */
public class AddCountFragment extends android.app.Fragment {

    private Spinner addSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.add_count_fragment, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        textView.setText(R.string.add_count);
        spinner.setVisibility(View.INVISIBLE);
        setHasOptionsMenu(true);


        addSpinner = (Spinner) rootView.findViewById(R.id.add_count_spinner);

        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(),
                R.layout.spinner_view, R.id.textNameSpinner, getSpinnerItem());
        addSpinner.setAdapter(adapter);

        addSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "click  " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                break;
            case R.id.action_settings1:
                break;
            case R.id.action_upgrade:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, new SettingUpgrade())
                        .addToBackStack(null)
                        .commit();
        }
        return true;
    }

    public ArrayList getSpinnerItem(){

        ArrayList<SpinnerItem> result = new ArrayList<>();

        SpinnerItem spinnerItem;
        spinnerItem = new SpinnerItem();
        spinnerItem.setImageSpinner(R.drawable.electro);
        spinnerItem.setTextSpinner(getString(R.string.electro));
        result.add(spinnerItem);

        spinnerItem = new SpinnerItem();
        spinnerItem.setImageSpinner(R.drawable.water);
        spinnerItem.setTextSpinner(getString(R.string.cWater));
        result.add(spinnerItem);

        spinnerItem = new SpinnerItem();
        spinnerItem.setImageSpinner(R.drawable.hwater);
        spinnerItem.setTextSpinner(getString(R.string.hWater));
        result.add(spinnerItem);

        spinnerItem = new SpinnerItem();
        spinnerItem.setImageSpinner(R.drawable.gas);
        spinnerItem.setTextSpinner(getString(R.string.gas));
        result.add(spinnerItem);

        spinnerItem = new SpinnerItem();
        spinnerItem.setImageSpinner(R.drawable.heating);
        spinnerItem.setTextSpinner(getString(R.string.heating));
        result.add(spinnerItem);

        return result;
    }
}
