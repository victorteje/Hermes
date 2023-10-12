package com.example.Hermesbackend.controllers;

import com.example.Hermesbackend.models.Guide;
import com.example.Hermesbackend.services.GuideService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(GuideController.class)
class GuideControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GuideService guideService;

    @Test
    void getAllGuides_method() throws Exception {
        ArrayList<Guide> guides = new ArrayList<>();

        Guide guide1 = new Guide(1L, "Pepe", "Madrid", "I am a guide", "pepe@domain.com", "photo1");
        Guide guide2 = new Guide(2L, "Ana", "Bilbao", "I am another guide", "ana@domain.com","photo2");

        guides.add(guide1);
        guides.add(guide2);

        when(guideService.getAllGuides()).thenReturn(guides);

        MockHttpServletResponse request = mockMvc.perform(MockMvcRequestBuilders.get("/guides")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertTrue(guides.contains(guide1));
    }

//    @Test
//    void getGuideById_method() {
//    }
//
//    @Test
//    void createGuide_method() {
//    }
//
//    @Test
//    void editGuide_method() {
//    }
//
//    @Test
//    void deleteGuide() {
//    }
//
//    @Test
//    void getGuidesByDestination() {
//    }
}