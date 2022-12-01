package com.aws.codestar.projecttemplates.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.Test;

class ItemStorageTest {



    @Test
    void storeItem_storespreviousitem() {

        //Given
        ItemStorage itemStorage = new ItemStorage();
        Item newitem = new Item(1, "Boat");

        // When
        itemStorage.storeItem(newitem);

        // Then
        assertThat(itemStorage.getItembyid(0), equalTo(newitem));

    }
}