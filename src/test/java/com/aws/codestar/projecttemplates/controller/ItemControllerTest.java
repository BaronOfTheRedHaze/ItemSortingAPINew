package com.aws.codestar.projecttemplates.controller;
import com.aws.codestar.projecttemplates.model.Item;
import com.aws.codestar.projecttemplates.model.ItemStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
 public class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Autowired

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ItemStorage itemStorage;

    @InjectMocks
    private ItemController itemController;


    Item item_1 = new Item(1, "Bike");

    Item item_2 = new Item(2, "Box" );

         //Före allt test

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    public void addItem() throws Exception {

        Item item = Item.builder()
                .id(3)
                .name("Rike")
                .build();


        String content = objectWriter.writeValueAsString(item);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        ResultActions result = mockMvc.perform(mockRequest);
       System.out.println(result);

    }

    @Test
    public void listItems() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/listitems")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("");

        ResultActions result = mockMvc.perform(mockRequest);
        System.out.println(result);

    }
    @Test


    public void getItemById() throws Exception {

        String content = objectWriter.writeValueAsString(item_2);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/getbyid?id=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        ResultActions result = mockMvc.perform(mockRequest);
        System.out.println(result);

    }

}

