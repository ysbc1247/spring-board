package com.projects.springboard.controller;

import com.projects.springboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@DisplayName("View Controller - authorization")
@Import(SecurityConfig.class)
@WebMvcTest
public class AuthControllerTest {
    private MockMvc mvc;

    public AuthControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }
    @DisplayName("[view][GET] login page - 정상 호출")
    @Test
    public void givenNothing_whenTryingToLogIn_thenReturnsLogInPage() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

}
