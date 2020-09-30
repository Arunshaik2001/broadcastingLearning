package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    myBroadCast myBroadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBroadCast=new myBroadCast();
    }


    public void sendSomething(View view){
//        Intent intent=new Intent(getString(R.string.action_unique));   //implicitly calling broadcastReciever
//        intent.putExtra("com.example.value","hi from sender to reciever");

        Intent intent=new Intent("com.example.myApplication.ACTION_SEND"); ///explicitly calling broadcastreceive class
        //ComponentName componentName=new ComponentName("com.example.recieverbroadcastapp","com.example.recieverbroadcastapp.myBroadCasReciever"); //explicitly calling another app broadcast reciever
        //intent.setComponent(componentName);

        PackageManager packageManager=getPackageManager();

        List<ResolveInfo> resolveInfos=packageManager.queryBroadcastReceivers(intent,0);

        for(ResolveInfo resolveInfo:resolveInfos){

            ComponentName componentName=new ComponentName(resolveInfo.activityInfo.packageName,resolveInfo.activityInfo.name);
            intent.setComponent(componentName);
            sendBroadcast(intent);
            Toast.makeText(this, componentName.getClassName(), Toast.LENGTH_SHORT).show();
        }


    }
}