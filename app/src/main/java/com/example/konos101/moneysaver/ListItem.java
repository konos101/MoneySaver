package com.example.konos101.moneysaver;

/**
 * Created by Konos101 on 18/08/2017.
 */

public class ListItem {

    //VALUES
    private int id;
    private String date;
    private String transName;
    private Float quantity;

    //CCONSTRUCTORS
    public ListItem(){

    }
    public ListItem(String date, String transName, Float quantity) {
        this.date = date;
        this.transName = transName;
        this.quantity = quantity;
    }

    public ListItem(int id, String date, String transName, Float quantity) {
        this.id = id;
        this.date = date;
        this.transName = transName;
        this.quantity = quantity;
    }

    //GETTERS
    public String getDate() {
        return date;
    }
    public String getTransName() {
        return transName;
    }
    public Float getQuantity() {
        return quantity;
    }
    public int getId() {
        return id;
    }

    //SETTERS
    public void setDate(String date) {
        this.date = date;
    }
    public void setTransName(String transName) {
        this.transName = transName;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
    public void setId(int id) {
        this.id = id;
    }
}
