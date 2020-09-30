package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

public class myBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.example.myApplication.ACTION_SEND".equals(intent.getAction())){
          {
              String connectivity=intent.getStringExtra("com.example.value");
              Toast.makeText(context, "sender app only"+connectivity, Toast.LENGTH_LONG).show();
          }
        }
        else Toast.makeText(context, "sender app only", Toast.LENGTH_LONG).show();
    }
}
