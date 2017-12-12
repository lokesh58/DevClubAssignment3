package com.lokesh58.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView counterDisplay;
    private int counter;
    private Animation animIn;
    private Animation animOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterDisplay = (TextView) findViewById(R.id.counterDisplay);
        counter = 0;
        animIn = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
        animOut= AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right);
        animOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                counterDisplay.startAnimation(animIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                counterDisplay.setText(Integer.toString(counter));
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void increaseCounter(View view) {
        counter++;
        counterDisplay.startAnimation(animOut);
    }

    public void decreaseCounter(View view) {
        if (counter == 0) {
            Toast.makeText(this, "Counter already at 0!", Toast.LENGTH_SHORT).show();
        } else {
            counter--;
            counterDisplay.startAnimation(animOut);
        }
    }

    public void resetCounter(View view) {
        if (counter != 0) {
            counter = 0;
            counterDisplay.startAnimation(animOut);
        }
    }
}
