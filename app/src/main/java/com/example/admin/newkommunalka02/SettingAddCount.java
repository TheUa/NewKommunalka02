package com.example.admin.newkommunalka02;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 29.09.2016.
 */

public class SettingAddCount extends PreferenceFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_add_count);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        textView.setText(R.string.action_settings);
        spinner.setVisibility(View.GONE);
        setHasOptionsMenu(true);

        final Preference prefElectro = findPreference("key_electro");
        final Preference prefCWater = findPreference("key_cWater");
        Preference prefHWater = findPreference("key_hWater");
        final Preference prefGas = findPreference("key_gas");
        final Preference prefHeating = findPreference("key_heating");

        prefElectro.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, new SettingElectroChoose())
                        .addToBackStack(null)
                        .commit();
                return false;
            }
        });

        prefCWater.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "click  " + prefCWater, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        prefHWater.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "click  " + prefCWater, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        prefGas.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "click  " + prefGas, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        prefHeating.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "click  " + prefHeating, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

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
}
