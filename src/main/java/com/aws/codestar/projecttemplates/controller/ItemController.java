package com.aws.codestar.projecttemplates.controller;
import com.aws.codestar.projecttemplates.model.Item;
import com.aws.codestar.projecttemplates.model.ItemStorage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/")
public class ItemController {

    ItemStorage itemStorage = new ItemStorage();

    @RequestMapping(value = "create", method = RequestMethod.POST)

    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        if (item == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(itemStorage.storeItem(item), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "getbyid")

     public ResponseEntity<Item> getById(@RequestParam("id") int id)
    {
        return new ResponseEntity<Item>(itemStorage.getItembyid(id), HttpStatus.OK);
    }

    @RequestMapping(value = "listitems")
    public ResponseEntity<ArrayList> listItems(){
        return new ResponseEntity<>(itemStorage.listItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "removebyid")

    public ResponseEntity<ArrayList> removeById(@RequestParam("id") int id)
    {
        itemStorage.removeItem(id);
        return new ResponseEntity<>(itemStorage.listItems(), HttpStatus.OK);
    }
}



