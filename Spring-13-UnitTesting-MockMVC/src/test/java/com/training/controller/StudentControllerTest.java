package com.training.controller;

import com.training.entity.Student;
import com.training.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest - will create all beans and do all the injections
//or
@WebMvcTest(StudentController.class) // will ring only one class and you need to inject dependencies on your own
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    void getStudent_service() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 0,"+ "\"firstName\": \"mike\"," + "\"lastName\": \"smith\"," + "\"age\": 25" + "}"))
                .andReturn();
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {
        String actual = "{id:0,firstName:mike,lastName: smith,age:20}";
        String expected = "{id:0,firstName:mike,lastName: smith}";

        JSONAssert.assertEquals(expected, actual, false); // strict = false will ignore missing some properties in comparable JSONs
    }

    @Test
    void getStudent_data() throws Exception {
        when(studentService.getStudent_data()).thenReturn(Arrays.asList(
                new Student("peter","jackson",50),
                new Student("john","jorgensen",20)
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{id:0,firstName:mike,lastName: smith,age:20}"))
                .andReturn();
    }

}