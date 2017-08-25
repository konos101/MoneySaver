package com.example.konos101.moneysaver;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Konos101 on 18/08/2017.
 */

public class DataBaseHandles extends SQLiteOpenHelper {

    //VARIABLES
    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "transactionsList";
    private static final String TABLE_TRANSACTIONS = "transactions";
    private static final String KEY_ID = "_ids";
    private static final String KEY_DATE = "date";
    private static final String KEY_NAME = "name";
    private static final String KEY_QUANTITY = "quantity";

    public DataBaseHandles(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TRANSACTIONLIST = "CREATE TABLE " + TABLE_TRANSACTIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DATE + " TEXT,"
                + KEY_NAME + " TEXT," + KEY_QUANTITY + " FLOAT" + ")";
        db.execSQL(CREATE_TRANSACTIONLIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_TRANSACTIONS);

        onCreate(db);
    }

    public void addTransaction(ListItem listItem){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, listItem.getId());
        values.put(KEY_DATE, listItem.getDate());
        values.put(KEY_NAME, listItem.getTransName());
        values.put(KEY_QUANTITY,listItem.getQuantity());

        db.insert(TABLE_TRANSACTIONS,null,values);
        db.close();
    }
    public ListItem getListItem(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TRANSACTIONS, new String[] {KEY_ID,
        KEY_DATE,KEY_NAME,KEY_QUANTITY}, KEY_ID + "=?",
                new String[] {String.valueOf(id)},null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        ListItem listItem = new ListItem(cursor.getString(1),
                cursor.getString(2),cursor.getFloat(3));

        return listItem;
    }
    public List<ListItem> getAllListItems(){
        List<ListItem> listItemList = new ArrayList<ListItem>();
        String selectQuery = "SELECT * FROM " + TABLE_TRANSACTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            ListItem listItem = new ListItem();
            do{
                listItem.setDate(cursor.getString(1));
                listItem.setTransName(cursor.getString(2));
                listItem.setQuantity(cursor.getFloat(3));

                listItemList.add(listItem);
            }while (cursor.moveToNext());
        }
        db.close();
        return listItemList;
    }

    public int getListItemsCount(){
        String countQuery = "SELECT * FROM " + TABLE_TRANSACTIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int total = cursor.getCount();
        cursor.close();

        return total;
    }
    public int updateListItem(ListItem listItem){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE,listItem.getDate());
        values.put(KEY_NAME, listItem.getTransName());
        values.put(KEY_QUANTITY,listItem.getQuantity());

        return db.update(TABLE_TRANSACTIONS, values, KEY_ID + " = ?",
                new String[] {String.valueOf(listItem.getId())});
    }
    public void deleteListItem(ListItem listItem){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTIONS, KEY_ID + " = ? ",
                new String[] {String.valueOf(listItem.getId())});

        db.close();

    }
}
