package com.example.admin.newkommunalka02;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Admin on 29.09.2016.
 */

public class SettingElectroLoad extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    private ListPreference categories;

    private SharedPreferences pref;

    private EditTextPreference k_key_tarif_electro;
    private EditTextPreference k_key_porog_electro1;
    private EditTextPreference k_key_tarif_electro1;
    private EditTextPreference k_key_porog_electro2;
    private EditTextPreference k_key_tarif_electro2;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_electro_load);

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

        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        initSummary(getPreferenceScreen());


        categories = (ListPreference) findPreference("key_electro_switch");
        k_key_tarif_electro = (EditTextPreference) findPreference("key_tarif_electro");
        k_key_porog_electro1 = (EditTextPreference) findPreference("key_porog_electro1");
        k_key_tarif_electro1 = (EditTextPreference) findPreference("key_tarif_electro1");
        k_key_porog_electro2 = (EditTextPreference) findPreference("key_porog_electro2");
        k_key_tarif_electro2 = (EditTextPreference) findPreference("key_tarif_electro2");

        Preference.OnPreferenceChangeListener
                sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object value) {
                String stringValue = value.toString();



                if (preference instanceof ListPreference) {
                    ListPreference listPreference = (ListPreference) preference;
                    int index = listPreference.findIndexOfValue(stringValue);

                    preference
                            .setSummary(index >= 0 ? listPreference.getEntries()[index]
                                    : null);

                    switch (index) {
                        case 0:
                            k_key_porog_electro1.setText(pref.getString("key_porog_electro_gorod1", ""));
                            k_key_porog_electro2.setText(pref.getString("key_porog_electro_gorod2", ""));
                            k_key_tarif_electro.setText(pref.getString("key_tarif_electro_gorod", ""));
                            k_key_tarif_electro1.setText(pref.getString("key_tarif_electro_gorod1", ""));
                            k_key_tarif_electro2.setText(pref.getString("key_tarif_electro_gorod2", ""));
                            break;
                        case 1:
                            k_key_porog_electro1.setText(pref.getString("key_porog_electro_selo1", ""));
                            k_key_porog_electro2.setText(pref.getString("key_porog_electro_selo2", ""));
                            k_key_tarif_electro.setText(pref.getString("key_tarif_electro_selo", ""));
                            k_key_tarif_electro1.setText(pref.getString("key_tarif_electro_selo1", ""));
                            k_key_tarif_electro2.setText(pref.getString("key_tarif_electro_selo2", ""));
                            break;
                        case 2:
                            k_key_porog_electro1.setText(pref.getString("key_porog_electro_pgt1", ""));
                            k_key_porog_electro2.setText(pref.getString("key_porog_electro_pgt2", ""));
                            k_key_tarif_electro.setText(pref.getString("key_tarif_electro_pgt", ""));
                            k_key_tarif_electro1.setText(pref.getString("key_tarif_electro_pgt1", ""));
                            k_key_tarif_electro2.setText(pref.getString("key_tarif_electro_pgt2", ""));
                            break;
                        default:
                            k_key_porog_electro1.setText(pref.getString("key_porog_electro1", ""));
                            k_key_porog_electro2.setText(pref.getString("key_porog_electro2", ""));
                            k_key_tarif_electro.setText(pref.getString("key_tarif_electro", ""));
                            k_key_tarif_electro1.setText(pref.getString("key_tarif_electro1", ""));
                            k_key_tarif_electro2.setText(pref.getString("key_tarif_electro2", ""));
                            break;

                    }
                }
                return true;
            }
        };
        categories.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

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
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    private void initSummary(Preference p) {
        if (p instanceof PreferenceGroup) {
            PreferenceGroup pGrp = (PreferenceGroup) p;
            for (int i = 0; i < pGrp.getPreferenceCount(); i++) {
                initSummary(pGrp.getPreference(i));
            }
        } else {
            updatePrefSummary(p);
        }
    }

    private void updatePrefSummary(Preference p) {

        if (p instanceof EditTextPreference) {
            EditTextPreference editTextPref = (EditTextPreference) p;

            String text = editTextPref.getText();
            if (text == null || "".equals(text)) {
                text = "-";
            }
            p.setSummary(text);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePrefSummary(findPreference(key));
    }
}
