package com.example.admin.newkommunalka02;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 20.08.2016.
 */
public class MainFragment extends android.app.Fragment {

    private RecyclerView recyclerView;
    private RecyclerView otherRecyclerView;
    private RecyclerView archiveRecyclerView;
    private RecyclerView.Adapter adapter;
    private SnapHelper snapHelper;
    private Object object;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);
        spinner.setVisibility(View.VISIBLE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.action_settings);
        textView.setText("");
        setHasOptionsMenu(true);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_recycler);
        otherRecyclerView = (RecyclerView) rootView.findViewById(R.id.other_recycler);
        archiveRecyclerView = (RecyclerView) rootView.findViewById(R.id.archive_recycler);


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        otherRecyclerView.setLayoutManager(linearLayoutManager1);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(otherRecyclerView);
        otherRecyclerView.setHasFixedSize(false);

        final LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        archiveRecyclerView.setLayoutManager(linearLayoutManager2);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(archiveRecyclerView);
        archiveRecyclerView.setHasFixedSize(false);

        final ArrayList setNewItem = getNewItem();
        adapter = new RecyclerViewAdapterHorizontal(setNewItem);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {

                object = setNewItem.get(position);
                NewsItem newsItem = (NewsItem) object;
                if (newsItem.getHeadline().equals(getString(R.string.add))) {

                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, new SettingAddCount())
                            .addToBackStack(null)
                            .commit();                }

                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), TarifActivity.class);


                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ImageView image = (ImageView) view.findViewById(R.id.counter_main);

                            String transitionName = getString(R.string.app_name);
                            ActivityOptions options = null;
                            options = ActivityOptions
                                    .makeSceneTransitionAnimation(getActivity(), image, transitionName);
                            startActivity(intent, options.toBundle());
                        } else {
                            startActivity(intent);
                        }

//                        getFragmentManager().beginTransaction()
//                                .replace(R.id.content_frame, new TarifFragment())
//                                .addToBackStack(null)
//                                .commit();
                        break;
                    case 1:
                        getFragmentManager()
                                .beginTransaction()
//                        .setCustomAnimations(
//                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
//                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
                                .replace(R.id.content_frame, new AddCountFragment())
                                .addToBackStack(null)
                                .commit();
                        break;

                }
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "click" + position, Toast.LENGTH_SHORT).show();
            }
        }));
        final ArrayList setOther = setOther();
        adapter = new RecyclerViewAdapterHorizontal(setOther);
        otherRecyclerView.setAdapter(adapter);

        adapter = new RecyclerViewAdapterHorizontal(setOther);
        archiveRecyclerView.setAdapter(adapter);

        return rootView;
    }

    private ArrayList setOther() {
        ArrayList<NewsItem> results = new ArrayList<>();
        NewsItem newsData;
        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.gek));
        newsData.setImageUrl(R.drawable.home);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.phone));
        newsData.setImageUrl(R.drawable.phone);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.garbage));
        newsData.setImageUrl(R.drawable.waste);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.tv));
        newsData.setImageUrl(R.drawable.tv);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.internet));
        newsData.setImageUrl(R.drawable.internet);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.domophon));
        newsData.setImageUrl(R.drawable.domophon);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.cleaning));
        newsData.setImageUrl(R.drawable.clean);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.other));
        newsData.setImageUrl(R.drawable.add);
        results.add(newsData);

        return results;
    }

    public ArrayList getNewItem() {

        ArrayList<NewsItem> results = new ArrayList<>();
        NewsItem newsData;
        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.electro));
        newsData.setImageUrl(R.drawable.electro);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString((R.string.cWater)));
        newsData.setImageUrl(R.drawable.water);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.hWater));
        newsData.setImageUrl(R.drawable.hwater);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.gas));
        newsData.setImageUrl(R.drawable.gas);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.heating));
        newsData.setImageUrl(R.drawable.heating);
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline(getString(R.string.add));
        newsData.setImageUrl(R.drawable.add);
        results.add(newsData);

        return results;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:

                break;
            case R.id.action_settings1:
//                getFragmentManager()
//                        .beginTransaction()
////                        .setCustomAnimations(
////                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
////                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
//                        .replace(R.id.content_frame, new SettingFragment())
//                        .addToBackStack(null)
//                        .commit();
                break;
            case R.id.action_upgrade:
                getFragmentManager()
                        .beginTransaction()
//                        .setCustomAnimations(
//                                R.anim.card_flip_right_in, R.anim.card_flip_right_out,
//                                R.anim.card_flip_left_in, R.anim.card_flip_left_out)
                        .replace(R.id.content_frame, new SettingUpgrade())
                        .addToBackStack(null)
                        .commit();
        }
        return true;
    }
    @Override
    public void onResume() {
        super.onResume();
        DatabaseHelperTarif databaseHelperTarif = new DatabaseHelperTarif(getActivity());

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
        Spinner spinner = (Spinner) toolbar.findViewById(R.id.spinner_nav);
        TextView textView = (TextView) toolbar.findViewById(R.id.text_nav);
        textView.setText("");
        spinner.setVisibility(View.VISIBLE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.action_settings);
    }
}
