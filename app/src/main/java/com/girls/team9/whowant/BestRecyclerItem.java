package com.girls.team9.whowant;

/**
 * Created by hyemi on 2015-08-13.
 */
public class BestRecyclerItem {
    String name;
    String price;
    int picture;

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public String getPrice() {
        return price;
    }

    public BestRecyclerItem(int picture, String name, String price) {
        this.name = name;
        this.picture = picture;
        this.price = price;
    }

}//class
