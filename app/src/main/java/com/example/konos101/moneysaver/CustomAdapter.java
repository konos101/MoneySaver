package com.example.konos101.moneysaver;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Konos101 on 17/08/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;

    private String date;
    private String transName;
    private Float quantity;

    private LayoutInflater inflater;

    public CustomAdapter(Context appContext, String date, String transName, Float quantity){
        this.context = appContext;
        this.date = date;
        this.transName = transName;
        this.quantity = quantity;
        inflater = (LayoutInflater.from(appContext));
    }


    //EXTENDS METHODS
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_list_view, null);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView transName = (TextView) convertView.findViewById(R.id.transName);
        TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
        date.setText(this.date);
        transName.setText(this.transName);
        quantity.setText(String.valueOf(this.quantity));

        return convertView;
    }
}
