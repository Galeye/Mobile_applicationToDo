package edu.gcit.sherigcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import edu.gcit.sherigcare.ui.slideshow.ForgotPassword;

public class MainActivity extends AppCompatActivity {
    private Spinner ddown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        ddown = findViewById(R.id.spinnermain);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.userType, R.layout.support_simple_spinner_dropdown_item);
        ddown.setAdapter(adapter);
    }

    public void mainfpWord(View view) {
        Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
        startActivity(intent);
    }


    public void login(View view) {
       String item = ddown.getSelectedItem().toString();
       if(item.equals("Admin")){
           Intent intent = new Intent(MainActivity.this, AdminDashBoard.class);
           startActivity(intent);
       }
       else if(item.equals("Teacher")){
           Intent intent = new Intent(MainActivity.this, TeacherDashBoard.class);
           startActivity(intent);
       }
       else if(item.equals("Parent")){
           Intent intent = new Intent(MainActivity.this, ParentDashBoard.class);
           startActivity(intent);
       }
       else{
           Toast.makeText(getApplicationContext(),"Invalid!",Toast.LENGTH_SHORT).show();
       }

    }
}