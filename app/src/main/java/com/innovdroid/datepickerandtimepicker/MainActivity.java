package com.innovdroid.datepickerandtimepicker;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // to get current time
        final Calendar c = Calendar.getInstance();

        final int year = c.get(c.YEAR);
        final int month = c.get(c.MONTH);
        final int day = c.get(c.DAY_OF_MONTH);
        final int hour = c.get(c.HOUR_OF_DAY);
        final int minute1 = c.get(c.MINUTE);
        final EditText date = (EditText) findViewById(R.id.dateEditText);
        final EditText time = (EditText) findViewById(R.id.timeEditText);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour1, int minute) {


                        time.getText().clear();
                        time.setText(hour1 + ":" + minute);
                    }   // default hour & minute
                }, hour, minute1, true);

                timePicker.setTitle("Select Time:");
                timePicker.show();

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePacker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {

                        // month1 returned ( zero based) so add 1 to it
                        month1++;
                        date.getText().clear();

                        // user choosed
                        date.setText(year1 + ":" + month1+ ":" + day1);
                    }
                    //  default date (current)
                }, year, month, day);
                datePacker.setTitle("Select Date:");
                datePacker.show();
            }
        });

    }
}
