package com.example.konos101.moneysaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    public void homeMenu(View v){
        Intent intent = new Intent(this, HomeMenu.class);
        startActivity(intent);

    }
}
