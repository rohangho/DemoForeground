package com.demosample.abc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText timer;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.editText);
    }

    public void abcStart(View view) {
        Intent serviceIntent = new Intent(this, ForeGroundService.class);
        serviceIntent.putExtra("timer", timer.getText().toString());
        ContextCompat.startForegroundService(this, serviceIntent);
    }
}