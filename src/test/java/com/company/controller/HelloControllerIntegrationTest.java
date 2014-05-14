package com.company.controller;

import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;


//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class})
@ContextConfiguration(locations = {"file:/Users/daiweilu/dev/_temp/SpringTestPractice/src/main/resources/application-context.xml"})
@WebAppConfiguration
public class HelloControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private WebClient webClient;


    @Before
    public void setup() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        webClient = new WebClient();
        webClient.setWebConnection(new MockMvcWebConnection(mockMvc));
    }


    @Test
    public void testPrintWelcome() throws Exception {
        UnexpectedPage welcomePage = webClient.getPage("http://localhost/");
        InputStream is = welcomePage.getInputStream();

        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String a = s.hasNext() ? s.next() : "";
        System.out.println(a);
    }
}
