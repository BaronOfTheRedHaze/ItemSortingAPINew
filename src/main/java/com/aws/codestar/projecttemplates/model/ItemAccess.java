package com.aws.codestar.projecttemplates.model;

import org.springframework.stereotype.Repository;

@Repository


// Class to create a list
// of items
public class ItemAccess {

    private static final ItemStorage list
            = new ItemStorage();

    // This static block is executed
    // before executing the main
    // block
    static
    {

        list.getItemList().add(new Item(1,"First text"));

    }

    // Method to return the list
    public ItemStorage getAllItems()
    {
        return list;
    }


    // Method to add an item
    // to the items list
    public void
    addItem(Item item)
    {
        list.getItemList().add(item);

    }
}