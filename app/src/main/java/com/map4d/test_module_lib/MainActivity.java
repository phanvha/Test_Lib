package com.map4d.test_module_lib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.map4d.awesome_library.MyView;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.mv);
        myView.setHintEditText("Enter anything ... ");
    }
}
