package dev.armancodeblock.tdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.armancodeblock.tdd.controller.ContactController;
import dev.armancodeblock.tdd.model.Person;
import dev.armancodeblock.tdd.repository.ContactRepository;
import dev.armancodeblock.tdd.service.ContactService;
import com.jayway.jsonpath.JsonPath;
import jakarta.persistence.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.annotation.Annotation;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class ApplicationTests {
    @Autowired
    ContactRepository repository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    public void checkController() {
        boolean hasAnnotation = false;

        Annotation annotation = AnnotationUtils.findAnnotation(ContactController.class, Controller.class);
        if (annotation != null) {
            hasAnnotation = true;
        }

        assertTrue(hasAnnotation);
    }


    @Test
    public void checkService() {
        boolean hasAnnotation = false;

        Annotation annotation = AnnotationUtils.findAnnotation(ContactService.class, Service.class);
        if (annotation != null) {
            hasAnnotation = true;
        }

        assertTrue(hasAnnotation);
    }

    @Test
    public void checkRepository() {
        boolean hasAnnotation = false;

        Annotation annotation = AnnotationUtils.findAnnotation(ContactRepository.class, Repository.class);
        if (annotation != null) {
            hasAnnotation = true;
        }

        assertTrue(hasAnnotation);
    }

    @Test
    public void checkEntity() {
        boolean hasAnnotation = false;

        Annotation annotation = AnnotationUtils.findAnnotation(Person.class, Entity.class);
        if (annotation != null) {
            hasAnnotation = true;
        }

        assertTrue(hasAnnotation);
    }

    @Test
    public void testPostPerson() throws Exception {
        Person person = new Person("John Doe", "84762834957");
        ObjectMapper objectMapper = new ObjectMapper();

        MockHttpServletResponse response = mockMvc.perform(post("/contact/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(person)))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.mobile").value("84762834957"))
                .andExpect(status().isCreated()).andReturn().getResponse();

        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");
        assertEquals(true, repository.findById(id).isPresent());

    }

    @Test
    public void testRetrievePerson() throws Exception {
        Person weather = new Person("John Doe", "84762834957");
        ObjectMapper objectMapper = new ObjectMapper();

        MockHttpServletResponse response = mockMvc.perform(post("/contact/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(weather)))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.mobile").value("84762834957"))
                .andExpect(status().isCreated()).andReturn().getResponse();
        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");

        mockMvc.perform(get("/contact/retrieve/" + id))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.mobile").value("84762834957"))
                .andExpect(status().isOk());

    }

    @Test
    public void testDeletePerson() throws Exception {
        Person person = new Person("John Doe", "84762834957");
        ObjectMapper objectMapper = new ObjectMapper();

        // Save the person
        MockHttpServletResponse response = mockMvc.perform(post("/contact/save")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(person)))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.mobile").value("84762834957"))
                .andExpect(status().isCreated()).andReturn().getResponse();

        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");

        // Delete the person
        mockMvc.perform(delete("/contact/delete/" + id))
                .andDo(print())
                .andExpect(status().isAccepted());

        // Verify the person is deleted
        assertTrue(repository.findById(id).isEmpty());
    }

    @Test
    public void testUpdatePerson() throws Exception {
        Person person = new Person("John Doe", "84762834957");
        ObjectMapper objectMapper = new ObjectMapper();

        // Save the person
        MockHttpServletResponse response = mockMvc.perform(post("/contact/save")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(person)))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.mobile").value("84762834957"))
                .andExpect(status().isCreated()).andReturn().getResponse();

        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");

        // Update the person
        Person updatedPerson = new Person("Jane Doe", "1234567890");

        mockMvc.perform(put("/contact/update/" + id)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updatedPerson)))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.mobile").value("1234567890"))
                .andExpect(status().isAccepted());

        // Verify the person is updated
        mockMvc.perform(get("/contact/retrieve/" + id))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.mobile").value("1234567890"))
                .andExpect(status().isOk());
    }


}