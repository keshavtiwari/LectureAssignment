package com.example.android.myapplication;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    CoordinatorLayout coordinatorLayout;
    LinearLayout linearLayout;
    private HorizontalSlider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        slider = (HorizontalSlider) findViewById(R.id.slider);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        final Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Hello bc ! ", Snackbar.LENGTH_LONG);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                slider.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                snackbar.show();

            }
        });
    }

}
