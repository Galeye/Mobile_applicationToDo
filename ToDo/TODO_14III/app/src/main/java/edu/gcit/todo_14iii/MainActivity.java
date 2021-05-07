package edu.gcit.todo_14iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //to show the calender
    public void showDate(View view) {
        //datepicker is the subclass of Dialog fragment
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }
    //to display date year and month in the form of string
    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String day_string = Integer.toString(day);

        String date_msg = (month_string+"/"+day_string+"/"+year_string);
        Toast.makeText(this, "Date: "+date_msg, Toast.LENGTH_SHORT).show();
    }
}