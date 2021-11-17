package com.progmatic.homework.Homework2.controllersTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser
    @Test
    void checkUsersWithoutLogin() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(
                        status().is(403)
                )
                .andReturn();
    }

    @WithMockUser
    @Test
    void checkUsersWithAdmin() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(
                        status().isOk()
                )
                .andReturn();
    }


}
