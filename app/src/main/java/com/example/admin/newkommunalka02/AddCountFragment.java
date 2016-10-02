package com.example.admin.newkommunalka02;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Admin on 16.09.2016.
 */
public class AddCountFragment extends android.app.Fragment {

    private TextView addCountText;
    private TextView addRecyclerText;
    private Spinner addSpinner;
    private SpinnerAdapter adapter;
    private View divider;
    private View divider1;
    private View divider2;
    private SwitchCompat switchCompat;
    private Spinner regionSpinner;
    private SharedPreferences sPref;
    private SettingPrefItems settingPrefItems;
    private RecyclerView recyclerAdd;

    public static String addCountSpinner = "addCountSpinner";


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.add_count_fragment, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        final Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        textView.setText(R.string.add_count);
        spinner.setVisibility(View.INVISIBLE);
        setHasOptionsMenu(true);

        addCountText = (TextView) rootView.findViewById(R.id.add_count_text);
        addSpinner = (Spinner) rootView.findViewById(R.id.add_count_spinner);
        divider = (View) rootView.findViewById(R.id.add_count_divider1);
        divider1 = (View) rootView.findViewById(R.id.add_count_divider2);
        divider2 = (View) rootView.findViewById(R.id.add_region);
        switchCompat = (SwitchCompat) rootView.findViewById(R.id.add_switch);
        regionSpinner = (Spinner) rootView.findViewById(R.id.add_region);
        recyclerAdd = (RecyclerView) rootView.findViewById(R.id.add_recycler);
        addRecyclerText = (TextView) rootView.findViewById(R.id.add_step);


        sPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final SharedPreferences.Editor editor = sPref.edit();

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        adapter = new SpinnerAdapter(getActivity(),
                R.layout.spinner_view, R.id.textNameSpinner, getSpinnerItem());

        settingPrefItems = new SettingPrefItems();
        addSpinner.setAdapter(adapter);
        onClickSpinner();

        addRecyclerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curSize;
                AddCountRecycler recyclerAdapter;

                if (recyclerAdd == null) {
                    recyclerAdd.setLayoutManager(linearLayoutManager);
                    recyclerAdd.setHasFixedSize(true);
                    recyclerAdapter = new AddCountRecycler(addStep());
                    recyclerAdd.setAdapter(recyclerAdapter);
                    curSize = recyclerAdapter.getItemCount();
                    return;

                } else {


                    recyclerAdd.setLayoutManager(linearLayoutManager);
                    recyclerAdd.setHasFixedSize(true);
                    recyclerAdapter = new AddCountRecycler(addStepOne());
                    recyclerAdd.setAdapter(recyclerAdapter);
                }


            }
        });

        addSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor.putInt(SettingPrefItems.addCountSpinner, position);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addCountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSpinner();
            }
        });

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    int spinnerPosition = sPref.getInt(SettingPrefItems.addCountSpinner, 0);
                    switchCompat.setText(R.string.load_tarif);
                    regionSpinner.setVisibility(View.VISIBLE);
//                    Log.e("007", getText(settingPref.getInt(settingPrefItems.addCountSpinner, 0)).toString());

                    switch (spinnerPosition) {
                        case 0:
                            regionSpinner.setAdapter(region(R.array.ectro_switch));
                            break;
                        case 3:
                            regionSpinner.setAdapter(region(R.array.gas_switch));
                            break;
                    }
                } else {
                    Log.e("007", String.valueOf(addStep().size()));
                    switchCompat.setText(R.string.input_tarif);
                    regionSpinner.setVisibility(View.GONE);
                }
            }
        });

        return rootView;
    }

    public ArrayAdapter<?> region(int array) {
        final ArrayAdapter<?> region = ArrayAdapter.createFromResource(getActivity(),
                array, android.R.layout.simple_spinner_item);
        region.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return region;
    }

    public void onClickSpinner() {
        new AlertDialog.Builder(getActivity())
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = sPref.edit();
                        addSpinner.setVisibility(View.VISIBLE);
                        addSpinner.setSelection(which);
                        divider.setVisibility(View.VISIBLE);
                        switchCompat.setVisibility(View.VISIBLE);
                        divider1.setVisibility(View.VISIBLE);
                        editor.putInt(addCountSpinner, which);
                        editor.apply();
                        dialog.dismiss();
                    }
                })
                .create().show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_setting, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
//                saveDB();
                break;
        }
        return true;
    }

    public ArrayList addStep() {
        ArrayList<NewsItem> add = new ArrayList<>();

        NewsItem newsItem;
        newsItem = new NewsItem();
        newsItem.setHeadline(getString(R.string.step));
        newsItem.setDate(getString(R.string.tarif_input2));
        add.add(newsItem);

        return add;
    }

    public ArrayList addStepOne() {
        ArrayList<NewsItem> add = new ArrayList<>();

        NewsItem newsItem;

        newsItem = new NewsItem();
        newsItem.setHeadline(getString(R.string.step));
        newsItem.setDate(getString(R.string.tarif_input2));
        add.add(newsItem);

        newsItem = new NewsItem();
        newsItem.setHeadline(getString(R.string.step1));
        newsItem.setDate(getString(R.string.tarif_input3));
        add.add(newsItem);

        return add;
    }

    public ArrayList getSpinnerItem() {

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
