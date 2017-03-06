package com.example.android.assignment3;

import android.app.Service;

import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Binder;

import android.os.IBinder;


import android.util.Log;
import android.widget.Toast;


public class MyService extends Service {
    MediaPlayer myPlayer;
    int pos=0;
    private IBinder mBinder = new MyBinder();




    @Override

    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();

        myPlayer = MediaPlayer.create(this, R.raw.song);
        myPlayer.setLooping(false);
        super.onCreate();


    }



    @Override

    public IBinder onBind(Intent intent) {

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
        return mBinder;

    }



    @Override

    public void onRebind(Intent intent) {
        /*check=intent.getIntExtra("",0);
        Toast.makeText(this,"in rebind",Toast.LENGTH_LONG).show();

        myPlayer.seekTo(pos);*/

    }



    @Override

    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"in unbind",Toast.LENGTH_LONG).show();

        /*
        myPlayer.pause();*/
        return true;


    }



    @Override

    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();}




    public void pause(){
        Toast.makeText(this, "paused", Toast.LENGTH_LONG).show();

        pos=myPlayer.getCurrentPosition();
        myPlayer.pause();
    }
    public void resume(){
        Toast.makeText(this, "resumed", Toast.LENGTH_LONG).show();

        myPlayer.seekTo(pos);
        myPlayer.start();
    }







    public class MyBinder extends Binder {

        MyService getService() {

            return MyService.this;

        }

    }

}


       /* */
//
//
