package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.Item;
import com.aws.codestar.projecttemplates.model.ItemAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 @RunWith(MockitoJUnitRunner.class)
 public class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Autowired
 //För att kunna konvertera JSON till en String

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectWriter objectWriter = objectMapper.writer();


    @Mock
    private ItemAccess itemAccess;


    @InjectMocks
    private ItemController itemController;


    Item item_1 = new Item(1, "Bike");

    Item item_2 = new Item(2, "Box" );

         //Före allt test

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build(); //Detta gör att det inte kör tomcat servern.
    }

    @Test
    public void addItem() throws Exception {

        Item item = Item.builder()
                .id(3)
                .name("Rike")
                .build();
        Mockito.when(itemAccess.createItem(item)).thenReturn(item);

        String content = objectWriter.writeValueAsString(item);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Rike")));

    }

}

