package com.aws.codestar.projecttemplates.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemAccess {


    ArrayList<Item> myItem = new ArrayList<>();
int latestItem;

    public Item createItem(Item newItem) {
        latestItem++;
        newItem.setId(latestItem);
        myItem.add(newItem);
        return newItem;
    }

}