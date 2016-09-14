package com.example.admin.newkommunalka02;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TarifActivity extends AppCompatActivity {

    private TextView dateText;
    private TextView timeText;
    private EditText count;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private RecyclerTarif adapter;
    private ImageView toolbarView;
    private TextView toolbarText;
    private TextView saveText;
    private TextView backText;

    private Calendar dateAndTime = Calendar.getInstance();

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarif);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarView = (ImageView) toolbar.findViewById(R.id.toolbar_view);
        toolbarText = (TextView) toolbar.findViewById(R.id.toolbar_text);
        toolbarView.setImageResource(R.drawable.electro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbarText.setText(R.string.electro);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });

        setupWindowAnimations();

        databaseHelper = new DatabaseHelper(this);

        dateText = (TextView) findViewById(R.id.count_date);
        timeText = (TextView) findViewById(R.id.time);
        count = (EditText) findViewById(R.id.count);
        saveText = (TextView) findViewById(R.id.save_text);
        backText = (TextView) findViewById(R.id.back_text);
        count.requestFocus();

        recyclerView = (RecyclerView) findViewById(R.id.tarif_recycler);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        final ArrayList setArchiveDB = getArchiveDB();
        adapter = new RecyclerTarif(setArchiveDB);
        recyclerView.setAdapter(adapter);

        backText.setOnClickListener(new View.OnClickListener() {
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
        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(view);
            }
        });

    }

    public void setDate(View v) {
        DatePickerDialog dialog = new DatePickerDialog(TarifActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        dialog.show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(TarifActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    // установка начальных даты
    private void setInitialDate() {

        dateText.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
//                        | DateUtils.FORMAT_SHOW_TIME));
//        timeText.setText(DateUtils.FORMAT_SHOW_TIME);

    }

    // установка начальных времени
    private void setInitialTime() {

        timeText.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));

    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialTime();
        }
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDate();
        }
    };

//    public static void ShowKeyboard(View pView) {
//        pView.RequestFocus();
//
//        InputMethodManager inputMethodManager = MyApplication.GetSystemService(Context.InputMethodService) as InputMethodManager;
//        inputMethodManager.ShowSoftInput(pView, ShowFlags.Forced);
//        inputMethodManager.ToggleSoftInput(ShowFlags.Forced, HideSoftInputFlags.ImplicitOnly);
//    }

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
                if (!TextUtils.isEmpty(count.getText().toString())) {
                    String date = (DateUtils.formatDateTime(this,
                            dateAndTime.getTimeInMillis(),
                            DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
                    String time = (DateUtils.formatDateTime(this,
                            dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
                    if (dateText.getText().toString().equals(getText(R.string.to_day_test))) {

                        if (timeText.getText().toString().equals(getText(R.string.to_time_test))) {

                            databaseHelper.addArchiveItem(new ArchiveItem
                                    (count.getText().toString(), date + " " + time, "", ""), databaseHelper.DATABASE_ELECTRO);
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                        databaseHelper.addArchiveItem(new ArchiveItem
                                (count.getText().toString(), date + " " + timeText.getText().toString(),
                                        "", ""), databaseHelper.DATABASE_ELECTRO);
                        Log.e("007", "дата");
                        return true;
                    }
                    if (timeText.getText().toString().equals(getText(R.string.to_time_test))) {
                        databaseHelper.addArchiveItem(new ArchiveItem
                                (count.getText().toString(), dateText.getText().toString() + " " + time,
                                        "", ""), databaseHelper.DATABASE_ELECTRO);
                        return true;
                    }
                    databaseHelper.addArchiveItem(new ArchiveItem
                            (count.getText().toString(), dateText.getText().toString() + " " +
                                    timeText.getText().toString(),
                                    "", ""), databaseHelper.DATABASE_ELECTRO);
                } else {

                    Snackbar snackbar = Snackbar.make(count, getText(R.string.count_start), Snackbar.LENGTH_LONG).setAction("Action", null);
                    View sbView = snackbar.getView();
                    TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    sbView.setBackgroundColor(ContextCompat.getColor(TarifActivity.this, R.color.colorPrimary));
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snackbar_textsize));
                    snackbar.show();
                }

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
                archiveItem.setArchiveTime(cursor.getString(3));
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
}

