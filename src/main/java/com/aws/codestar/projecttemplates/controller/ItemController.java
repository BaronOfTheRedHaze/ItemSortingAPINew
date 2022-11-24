package com.aws.codestar.projecttemplates.controller;
import com.aws.codestar.projecttemplates.model.Item;
import com.aws.codestar.projecttemplates.model.ItemAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/")
public class ItemController {

    ItemAccess itemAccess = new ItemAccess();

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item addItem = itemAccess.createItem(item);
        return new ResponseEntity<>(addItem, HttpStatus.OK);
    }


}





