package com.aws.codestar.projecttemplates.controller;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class ItemControllerTest {

    @Test
    void getItemList() {
        int sum = 123;
        assertThat(sum, is(equalTo(123)));
    }

    @Test
    void addItemName() {


    }
}