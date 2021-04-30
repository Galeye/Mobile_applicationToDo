package edu.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tview;

    private String[] mcolorArr = {"red", "pink", "purple","blue","orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tview = findViewById(R.id.textView1);
    }


    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mcolorArr[random.nextInt(5)];

        int colorResName = getResources().getIdentifier(colorName,"color", getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this, colorResName);
        tview.setTextColor(colorRes);

    }
}