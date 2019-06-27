package com.example.mvc;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {
    private Model model;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model();
        model.addObserver(this);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                model.setValueAtIndex(0);
                break;
            case R.id.button2:
                model.setValueAtIndex(1);
                break;
            case R.id.button3:
                model.setValueAtIndex(2);
                break;
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        button1.setText(String.valueOf(model.getValueAtIndex(0)));
        button2.setText(String.valueOf(model.getValueAtIndex(1)));
        button3.setText(String.valueOf(model.getValueAtIndex(2)));

    }
}
