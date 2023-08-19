package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText editText;
    int Year , month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.txt1);
        Calendar calendar=Calendar.getInstance();
         Year=calendar.get(Calendar.YEAR);
         month=calendar.get(Calendar.MONTH);
         day=calendar.get(Calendar.DAY_OF_MONTH);

        editText.setText(Year+"_"+month+"_"+day);
        
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }
DatePickerDialog.OnDateSetListener Listener=new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int Year, int month, int dayOfMonth) {
        editText.setText(Year+"_"+month+"_"+day);
    }
};
    private void showDateDialog() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(this,Listener,Year,month,day);
        datePickerDialog.show();
    }
}