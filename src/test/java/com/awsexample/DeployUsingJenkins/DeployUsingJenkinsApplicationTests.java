package com.awsexample.DeployUsingJenkins;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DeployUsingJenkinsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllVegies() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/allVegies")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getSingleVegieInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vegie/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnNotFoundForInvalidVegieInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vegie/9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void createNewVegie() throws Exception {
        String newVegie = " {\"name\": \"Potato\", \"description\": \"not suitable for cholestrol disease\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/saveVegie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newVegie)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }
}
