package com.aws.codestar.projecttemplates.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemStorage {

    ArrayList<Item> myItem = new ArrayList<>();
    public Item getItembyid(int id) {

            if (myItem == null){
            myItem = new ArrayList<>();
            }

        return myItem.get(id);
    }

    int latestItem;

    public Item storeItem(Item newItem) {
        latestItem++;
        newItem.setId(latestItem);
        myItem.add(newItem);
        return newItem;
    }

    public ArrayList<Item> listItems(){
        return myItem;
    }

    public void removeItem(int id){
        myItem.remove(id);
    }
}