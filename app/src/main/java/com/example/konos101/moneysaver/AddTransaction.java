package com.example.konos101.moneysaver;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by Konos101 on 17/08/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class AddTransaction extends Activity{

    private Context context = this;
    private EditText dateText,txtTransName,txtQuantity;
    private final Calendar myTransDate = Calendar.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        //INITIALIZE TEXTVIEWS
        dateText = (EditText) findViewById(R.id.datePicker);
        txtTransName = (EditText) findViewById(R.id.TransactionName);
        txtQuantity = (EditText) findViewById(R.id.Quantity);

        //MAKE DATETEXTVIEW ON SELECT OPEN DATEPICKER
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myTransDate.set(Calendar.YEAR, year);
                myTransDate.set(Calendar.MONDAY, dayOfMonth);
                myTransDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context,date,myTransDate.get(Calendar.YEAR),myTransDate.get(Calendar.MONTH),myTransDate.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //MAKE DATE FORMAT TO STRING
    private void updateLabel(){
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        dateText.setText(sdf.format(myTransDate.getTime()));
    }

    public void addNew(View v){

        Intent intent = new Intent(this, HomeMenu.class);
        intent.putExtra("date",dateText.getText().toString());
        intent.putExtra("name",txtTransName.getText().toString());
        intent.putExtra("quantity",txtQuantity.getText().toString());
        startActivity(intent);
    }
}
