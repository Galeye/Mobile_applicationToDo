package edu.gcit.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MSG = "edu.gcit.todo12";
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu,m);
        return super.onCreateOptionsMenu(m);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.order:
                Intent intent = new Intent(MainActivity.this,todo13.class);
                startActivity(intent);
                return true;
            case R.id.status:
                displayToast("status");
                return true;
            case R.id.fav:
                displayToast("favourite");
                return true;
            case R.id.cont:
                displayToast("Contact");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void donut(View view) {
        msg = getString(R.string.donut_order_message);
        displayToast(msg);
    }

    public void ice(View view) {
        msg = getString(R.string.ice_cream_order_message);
        displayToast(msg);
    }

    public void foryo(View view) {
        msg = getString(R.string.froyo_order_message);
        displayToast(msg);

    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view) {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:77354374"));

        Intent intent = new Intent(MainActivity.this, todo13.class);
        intent.putExtra(EXTRA_MSG, msg);
        startActivity(intent);
    }
}