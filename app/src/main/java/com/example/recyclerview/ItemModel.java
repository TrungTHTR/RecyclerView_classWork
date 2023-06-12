package com.example.recyclerview;

import java.io.Serializable;

public class ItemModel  implements Serializable {
    private int resourceID;
    private String name;
    private String price;
    public ItemModel(int resourceID, String name,String price) {
        this.resourceID = resourceID;
        this.name = name;
        this.price=price;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
