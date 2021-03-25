package edu.gcit.todo_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int nCount;
    private TextView showCount;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount =(TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        nCount=0;
        if(savedInstanceState != null){
            nCount = savedInstanceState.getInt("count");
            showCount.setText(String.valueOf(nCount));
        }
    }

    public void countUp(View view) {
        nCount++;
        if (showCount != null)
            showCount.setText(Integer.toString(nCount));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",nCount);
    }
}