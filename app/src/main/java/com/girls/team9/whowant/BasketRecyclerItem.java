package com.girls.team9.whowant;

/**
 * Created by eugene on 2015-08-14.
 */
public class BasketRecyclerItem {
    int image;
    String name;
    String number;
    String price;

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPrice() {
        return price;
    }

    public BasketRecyclerItem(int image, String name, String number, String price) {
        this.image = image;
        this.name = name;
        this.number = number;
        this.price = price;
    }
}
