package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.Item;
import com.aws.codestar.projecttemplates.model.ItemAccess;
import com.aws.codestar.projecttemplates.model.ItemStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Creating the REST controller
@RestController
@RequestMapping(path = "/itemStorage")
public class ItemController {

    @Autowired
    private ItemAccess itemAccess;

    public ItemController(ItemAccess itemAccess) {
        this.itemAccess = itemAccess;
    }

    // Implementing a GET method
    // to get the list of all
    // the items
    @GetMapping(
            path = "/",
            produces = "application/json")

    public ItemStorage getItemList()
    {

        return itemAccess
                .getAllItems();
    }


    // Create a POST method
    // to add an item
    // to the list
    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addItemName(
            @RequestBody Item inputitem)
    {

        // Creating an ID of an item
        // from the number of items
        // in the array list
        Integer id
                = itemAccess
                .getAllItems()
                .getItemList()
                .size()
                + 1;

        inputitem.setId(id);

        itemAccess.addItem(inputitem);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        inputitem.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}



