package edu.gcit.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText val;
    private EditText val2;
    private TextView ans;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val = findViewById(R.id.number1);
        val2 = findViewById(R.id.number2);
        ans = findViewById(R.id.answer);
        calc = new Calculator();

    }

    public void add(View view) {
        String n = val.getText().toString();
        String n2 = val2.getText().toString();
        double resAdd = calc.add(Double.valueOf(n),Double.valueOf(n2));
        ans.setText(String.valueOf(resAdd));

        Log.d("dubug", "add:debug");
    }

    public void subtract(View view) {
        String n = val.getText().toString();
        String n2 = val2.getText().toString();
        double resSub = calc.subtract(Double.valueOf(n), Double.valueOf(n2));
        ans.setText(String.valueOf(resSub));
    }

    public void multiply(View view) {
        String n = val.getText().toString();
        String n2 = val2.getText().toString();
        double resMul = calc.multiply(Double.valueOf(n), Double.valueOf(n2));
        ans.setText(String.valueOf(resMul));
    }

    public void divide(View view) {
        String n = val.getText().toString();
        String n2 = val2.getText().toString();
        double resDiv = calc.division(Double.valueOf(n), Double.valueOf(n2));
        ans.setText(String.valueOf(resDiv));
    }
}