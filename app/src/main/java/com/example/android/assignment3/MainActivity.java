package com.example.android.assignment3;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStart,buttonStop,buttonPause,buttonResume;
    MyService mBoundService;

    boolean mServiceBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Service is On")
                        .setContentText(" How deep is your love ! ");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        final NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        buttonStart = (Button) findViewById(R.id.start_button);
        buttonStop = (Button) findViewById(R.id.stop_button);
        buttonPause = (Button) findViewById(R.id.pause_button);
        buttonResume=(Button) findViewById(R.id.resume_button);

        final Intent i=new Intent(this, MyService.class);
        final Intent j=new Intent(this,MyService.class);
        j.putExtra("",1);



        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(i, mServiceConnection, Context.BIND_AUTO_CREATE);
                manager.notify(0, builder.build());


            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mServiceConnection);
                manager.cancel(0);

            }
        });
        buttonResume.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mBoundService.resume();
            }
        });
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBoundService.pause();
            }
        });



    }
    private ServiceConnection mServiceConnection = new ServiceConnection() {



        @Override

        public void onServiceDisconnected(ComponentName name) {

            mServiceBound = false;

        }



        @Override

        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.MyBinder myBinder = (MyService.MyBinder) service;

            mBoundService = myBinder.getService();

            mServiceBound = true;

        }

    };

}



