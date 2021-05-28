package edu.gcit.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + "ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
      String intentAction = intent.getAction();
      if (intentAction!=null){
          String toastMsg = " ";
          switch(intentAction){
              case Intent.ACTION_POWER_CONNECTED:
                  toastMsg = "Power connected";
                  break;
              case Intent.ACTION_POWER_DISCONNECTED:
                  toastMsg="Power disconnected";
                  break;
              case ACTION_CUSTOM_BROADCAST:
                  toastMsg = "Custom Broadcast received";
                  break;
          }
          Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
      }
    }
}