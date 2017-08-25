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
import java.util.List;

/**
 * Created by Konos101 on 16/08/2017.
 */

public class HomeMenu extends AppCompatActivity {

    private Button add;
    private TextView textMonth;
    public ListView listTrans;
    private DataBaseHandles db = new DataBaseHandles(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        listTrans =(ListView) findViewById(R.id.listTrans);

        CustomAdapter customAdapter = null;
        List<ListItem> listItems = db.getAllListItems();
        if (!listItems.isEmpty() || listItems != null) {
            int count = db.getListItemsCount();
            for (int i = 0; i < count; i++){
                customAdapter = new CustomAdapter(getApplicationContext(), listItems.get(i).getDate(), listItems.get(i).getTransName(), listItems.get(i).getQuantity());
                listTrans.setAdapter(customAdapter);

            }


            /*
            for (ListItem item : listItems) {
                customAdapter = new CustomAdapter(getApplicationContext(), item.getDate(), item.getTransName(), item.getQuantity());
                int hola = item.getId();
                listTrans.setAdapter(customAdapter);
            }*/

        }

        textMonth = (TextView) findViewById(R.id.textMonth);

        add = (Button) findViewById(R.id.btnNewTrans);
    }

    public void onAdd(View v){
        Intent intent = new Intent(this, AddTransaction.class);
        startActivity(intent);
    }

    public void nextMonth(View v){

    }

    public void lastMonth(View v){

    }
}

