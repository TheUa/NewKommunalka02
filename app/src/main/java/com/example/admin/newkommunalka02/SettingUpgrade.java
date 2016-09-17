package com.example.admin.newkommunalka02;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Admin on 09.02.2016.
 */
public class SettingUpgrade extends PreferenceFragment {

    private FileJsonTaskDownload fileJsonTaskDownload;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_upgrade);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        textView.setText(R.string.action_settings);
        spinner.setVisibility(View.INVISIBLE);
        setHasOptionsMenu(true);

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (mSettings.getInt("test_download", 0) != 1) {

            fileJsonTaskDownload = new FileJsonTaskDownload(getActivity());
            fileJsonTaskDownload.execute();

        }
        Preference myPref0 = findPreference("key_download");
        myPref0.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {

                fileJsonTaskDownload = new FileJsonTaskDownload(getActivity());
                fileJsonTaskDownload.execute();

                return false;
            }
        });

        Preference myPref = findPreference("key_electro");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
//                getFragmentManager()
//                        .beginTransaction()
////                        .setCustomAnimations(
////                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
////                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
//                        .replace(R.id.content_frame, new SettingElectro())
//                        .addToBackStack(null)
//                        .commit();
                return false;
            }
        });
        Preference myPref1 = findPreference("key_cWater");
        myPref1.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
//                getFragmentManager()
//                        .beginTransaction()
////                        .setCustomAnimations(
////                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
////                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
//                        .replace(R.id.content_frame, new SettingCWater())
//                        .addToBackStack(null)
//                        .commit();
                return false;
            }
        });
        Preference myPref2 = findPreference("key_hWater");
        myPref2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
//                getFragmentManager()
//                        .beginTransaction()
////                        .setCustomAnimations(
////                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
////                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
//                        .replace(R.id.content_frame, new SettingMyHWater())
//                        .addToBackStack(null)
//                        .commit();
                return false;
            }
        });
        Preference myPref3 = findPreference("key_gas");
        myPref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
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

    @Override
    public void onResume() {
        super.onResume();
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        textView.setText(R.string.action_settings);
        spinner.setVisibility(View.INVISIBLE);
        setHasOptionsMenu(true);
    }
}
