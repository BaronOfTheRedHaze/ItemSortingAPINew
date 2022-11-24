package com.aws.codestar.projecttemplates.model;


import java.util.ArrayList;
import java.util.List;

// Class to store the list of
// all the items in an
// Array List
public class ItemStorage {

    private List<Item> itemList;

    // Method to return the list
    // of items
    public List<Item> getItemList()
    {

        if (itemList == null) {

            itemList
                    = new ArrayList<>();

        }

        return itemList;

    }

    public void setItemList(List<Item> itemList)
    {
        this.itemList
                = itemList;
    }
}
