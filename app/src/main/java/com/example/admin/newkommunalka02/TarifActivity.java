package com.example.admin.newkommunalka02;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.transition.Slide;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TarifActivity extends AppCompatActivity {

    private TextView dateText;
    private TextView noteText;
    private EditText count;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private RecyclerTarif adapter;
    private ImageView toolbarView;
    private TextView toolbarText;
    private TextView saveText;
    private TextView backText;
    private ImageView backImage;
    private ImageView saveImage;
    private ImageView noteImage;

    private Calendar dateAndTime = Calendar.getInstance();

    private SimpleDateFormat dateFormatter;

    private ArrayList setArchiveDB;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarif);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarView = (ImageView) toolbar.findViewById(R.id.toolbar_view);
        toolbarText = (TextView) toolbar.findViewById(R.id.toolbar_text);
        toolbarView.setImageResource(R.drawable.electro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarText.setText(R.string.electro);

        setupWindowAnimations();

        databaseHelper = new DatabaseHelper(this);

        dateText = (TextView) findViewById(R.id.count_date);
        noteText = (TextView) findViewById(R.id.note);
        count = (EditText) findViewById(R.id.count);
        saveText = (TextView) findViewById(R.id.save_text);
        backText = (TextView) findViewById(R.id.back_text);
        backImage = (ImageView) findViewById(R.id.back_image);
        saveImage = (ImageView) findViewById(R.id.save_image);
        noteImage = (ImageView) findViewById(R.id.count_note);
        count.requestFocus();

        recyclerView = (RecyclerView) findViewById(R.id.tarif_recycler);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        setArchiveDB = getArchiveDB();
        adapter = new RecyclerTarif(setArchiveDB);
        recyclerView.setAdapter(adapter);

        clicker();
    }

    public void setDate(View v) {
        DatePickerDialog dialog = new DatePickerDialog(TarifActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        dialog.show();
    }

    // установка начальных даты
    private void setInitialDate() {

        dateText.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));

    }

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDate();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
                saveDB();
                break;
        }
        return true;
    }

    private ArrayList<ArchiveItem> getArchiveDB() {
        ArrayList<ArchiveItem> archiveList = new ArrayList<>();

        int increm = 1;

//        databaseHelper = new DatabaseHelper(this);
        // Выбираем всю таблицу
        String selectQuery = "SELECT * FROM " + databaseHelper.DATABASE_ELECTRO;

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Проходим по всем строкам и добавляем в список
        if (cursor.moveToFirst()) {
            do {
                ArchiveItem archiveItem = new ArchiveItem();
//                archiveItem.setArchiveId(Integer.parseInt(cursor.getString(0)));
                archiveItem.setArchiveId(increm++);
                archiveItem.setArchiveCount(cursor.getString(1));
                archiveItem.setArchiveDate(cursor.getString(2));
                archiveItem.setArchiveSum(cursor.getString(3));
                archiveItem.setArchiveDescr(cursor.getString(4));
                archiveList.add(0, archiveItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return archiveList;
    }

    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slideTransition = null;
            slideTransition = new Slide();
            slideTransition.setSlideEdge(Gravity.BOTTOM);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    private void alertDialogComment() {
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.note);
        builder.setIcon(R.drawable.note);
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input); // uncomment this line
        input.requestFocus();
        builder.setPositiveButton(getString(R.string.on),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputText;
                        inputText = input.getText().toString();
                        noteText.setText(inputText);
                    }
                })
                .setNegativeButton(getString(R.string.off),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
        alertDialog = builder.create();
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        alertDialog.show();
    }

    public void saveDB() {
        if (!TextUtils.isEmpty(count.getText().toString())) {
            String date = (DateUtils.formatDateTime(this,
                    dateAndTime.getTimeInMillis(),
                    DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
            String note = noteText.getText().toString();
            if (dateText.getText().toString().equals(getText(R.string.to_day_test))) {
                if (noteText.getText().toString().equals(getText(R.string.note))) {
                    databaseHelper.addArchiveItem(new ArchiveItem
                            (count.getText().toString(), date, "", ""), databaseHelper.DATABASE_ELECTRO);
                    setArchiveDB.clear();
                    setArchiveDB = getArchiveDB();
                    adapter.notifyDataSetChanged();
                    return;
                }
                databaseHelper.addArchiveItem(new ArchiveItem
                        (count.getText().toString(), date,
                                "", note), databaseHelper.DATABASE_ELECTRO);
                Log.e("007", "дата");
                setArchiveDB.clear();
                setArchiveDB = getArchiveDB();
                adapter.notifyDataSetChanged();
                return;
            }
            if (noteText.getText().toString().equals(getText(R.string.note))) {
                databaseHelper.addArchiveItem(new ArchiveItem
                        (count.getText().toString(), dateText.getText().toString(),
                                "", ""), databaseHelper.DATABASE_ELECTRO);
                setArchiveDB.clear();
                setArchiveDB = getArchiveDB();
                adapter.notifyDataSetChanged();
                return;
            }
            databaseHelper.addArchiveItem(new ArchiveItem
                    (count.getText().toString(), dateText.getText().toString(),
                            "", note), databaseHelper.DATABASE_ELECTRO);
            setArchiveDB.clear();
            setArchiveDB = getArchiveDB();
            adapter.notifyDataSetChanged();
        } else {
            Snackbar snackbar = Snackbar.make(count, getText(R.string.count_start), Snackbar.LENGTH_LONG).setAction("Action", null);
            View sbView = snackbar.getView();
            TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            sbView.setBackgroundColor(ContextCompat.getColor(TarifActivity.this, R.color.colorPrimary));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snackbar_textsize));
            snackbar.show();
        }
    }

    public void clicker(){

        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(view);
            }
        });
        noteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogComment();
            }
        });
        noteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogComment();
            }
        });
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDB();
            }
        });
        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDB();
            }
        });
    }
}

