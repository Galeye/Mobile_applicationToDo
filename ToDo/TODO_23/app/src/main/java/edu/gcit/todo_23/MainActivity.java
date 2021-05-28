package edu.gcit.todo_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CustomReceiver mReceiver;
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + "ACTION_CUSTOM_BROADCAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver = new CustomReceiver();
        IntentFilter filter = new IntentFilter();
        //System will broadcast the msg
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(mReceiver, filter); //to register the receiver

        //2.register broadcast
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver); //to prevent memory leakage
        //2. unregister broadcast
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    //1.create and send data
    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}