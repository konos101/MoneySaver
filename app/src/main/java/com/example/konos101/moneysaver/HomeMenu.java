package com.example.konos101.moneysaver;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Konos101 on 16/08/2017.
 */

public class HomeMenu extends AppCompatActivity {

    private Button add;
    private TextView textMonth;
    public ListView listTrans;

    /*
    String date[] = {"16/02/1996","01/10/1997","16/04/2007","16/02/1996","01/10/1997","16/04/2007"};
    String transName[] = {"Connor","Ariadna","Ryan","Connor","Ariadna","Ryan"};
    String quantity[] = {"21","19","10","21","19","10"};
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        textMonth = (TextView) findViewById(R.id.textMonth);
        //textMonth.setText();

        listTrans =(ListView) findViewById(R.id.listTrans);
        Intent intent = getIntent();
        addToList(intent);

        add = (Button) findViewById(R.id.btnNewTrans);
    }

    public void onAdd(View v){
        Intent intent = new Intent(this, AddTransaction.class);
        startActivity(intent);
    }
    public void addToList(Intent intent){
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),intent.getStringExtra("date"),intent.getStringExtra("name"),intent.getStringExtra("quantity"));

        listTrans.setAdapter(customAdapter);
    }

    public void nextMonth(View v){

    }

    public void lastMonth(View v){

    }
}

