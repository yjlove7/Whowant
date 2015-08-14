package com.girls.team9.whowant;

import com.parse.ParseFile;

/**
 * Created by hyemi on 2015-08-13.
 */
public class BestRecyclerItem {
    String name;
    String price;
    int picture;
    int number;

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public String getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public BestRecyclerItem(int picture, String name, String price) {
        this.name = name;
        this.picture = picture;
        this.price = price;
    }

    public BestRecyclerItem(String name, int number, int picture, String price) {
        this.name = name;
        this.number = number;
        this.picture = picture;
        this.price = price;
    }

}//class
