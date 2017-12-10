package com.lokesh58.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView counterDisplay;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterDisplay = (TextView) findViewById(R.id.counterDisplay);
    }

    public void increaseCounter(View view) {
        counter++;
        counterDisplay.setText(Integer.toString(counter));
    }

    public void decreaseCounter(View view) {
        counter--;
        if (counter < 0) {
            counter = 0;
            Toast.makeText(this, "Counter already at 0!", Toast.LENGTH_SHORT).show();
        }
        counterDisplay.setText(Integer.toString(counter));
    }
}
