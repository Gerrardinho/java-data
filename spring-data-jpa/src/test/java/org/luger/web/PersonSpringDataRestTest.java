package org.luger.web;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by gerardo8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonSpringDataRestTest {

    @Rule
    public JUnitRestDocumentation restDocumentation
        = new JUnitRestDocumentation("build/genereted-snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc  mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.context)
            .apply(documentationConfiguration(this.restDocumentation))
            .build();
    }


    @Test
    public void getPersonWhenRequestingJsonShouldReturnModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/people/1").accept(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

}
