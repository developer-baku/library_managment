package org.services.library_management;

import org.junit.jupiter.api.Test;
import org.services.library_management.controllers.ControllerRecords;
import org.services.library_management.dto.ResponsePatron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryManagementApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void checkIfBorrowingAndReturningWorks(@Autowired MockMvc mockMvc) throws Exception {

        MvcResult resultBorrow = mockMvc.perform(post("/api/borrow/{bookId}/patron/{patronId}", 1,1)).andReturn();
        MvcResult resultReturn = mockMvc.perform(put("/api/return/{bookId}/patron/{patronId}", 1,1)).andReturn();

        assertEquals(resultBorrow.getResponse().getStatus(), 200);
        assertEquals(resultReturn.getResponse().getStatus(), 200);

    }

    @Test
    void  allBooks(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/api/books")).andExpect(status().isOk());
    } @Test
    void  BookWithId(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/api/books/{id}",1)).andExpect(status().isFound());
    }
    @Test
    void  PatronWithId(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/api/patrons/{id}",1)).andExpect(status().isFound());
    }
}
