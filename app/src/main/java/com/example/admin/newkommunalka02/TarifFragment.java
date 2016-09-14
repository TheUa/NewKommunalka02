package com.example.admin.newkommunalka02;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by Admin on 23.08.2016.
 */
public class TarifFragment extends android.app.Fragment {

    private TextView dateText;
    private EditText count;
    private TextView timeText;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        setHasOptionsMenu(true);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View rootView = inflater.inflate(R.layout.tarif, container, false);

        count = (EditText) rootView.findViewById(R.id.count);
        dateText = (TextView) rootView.findViewById(R.id.count_date);
//        timeText = (TextView) rootView.findViewById(R.id.count_time);
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Work", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }


//    private void setDateTimeField() {
//
//        Calendar newCalendar = Calendar.getInstance();
//        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
//
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
//                String d = (dateFormatter.format(newDate.getTime()));
//            }
//
//        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//
//        toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
//
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
//                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
//            }
//
//        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//    }
}
