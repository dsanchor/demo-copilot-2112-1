package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse")
                .param("input", "Hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleH"));
    }

    @Test
    public void testReverseStringEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testReverseStringWithSpecialChars() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse")
                .param("input", "Hello World!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!dlroW olleH"));
    }

    @Test
    public void testRemoveVocals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/removevocals")
                .param("input", "Hello World"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld"));
    }

    @Test
    public void testRemoveVocalsEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/removevocals")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testRemoveVocalsWithSpecialChars() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/removevocals")
                .param("input", "Hello World!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld!"));
    }

    @Test
    public void testIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/palindrome")
                .param("input", "level"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testIsNotPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/palindrome")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @Test
    public void testEmptyStringIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/palindrome")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testSingleCharacterIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/palindrome")
                .param("input", "a"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
    
}