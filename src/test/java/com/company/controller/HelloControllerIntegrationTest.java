package com.company.controller;

import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/application-context.xml"})
@WebAppConfiguration
public class HelloControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;


    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }


//    @Ignore
//    @Test
//    public void testPrintWelcome() throws Exception {
//        UnexpectedPage welcomePage = webClient.getPage("http://localhost/");
//        InputStream is = welcomePage.getInputStream();
//
//        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
//        String a = s.hasNext() ? s.next() : "";
//        System.out.println(a);
//    }


//    @Ignore
    @Test
    public void testHelloController() throws Exception
    {
        mockMvc.perform(    MockMvcRequestBuilders.get("/welcome") )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andDo(     MockMvcResultHandlers.print() );
//                .andExpect( MockMvcResultMatchers.content().contentType("text/html") );
//                .andExpect( MockMvcResultMatchers.jsonPath("$.name").value("Lee") );


    }
}
