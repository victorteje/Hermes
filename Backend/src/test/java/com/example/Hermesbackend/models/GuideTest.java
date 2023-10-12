package com.example.Hermesbackend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuideTest {

    @Test
    void has_id_name_destination_details_and_email() {

        Guide guide = new Guide(1L, "Pepe", "Madrid", "I am a guide", "pepe@domain.com", "photo1.com");

        Long id = guide.getId();
        String name = guide.getName();
        String destination = guide.getDestination();
        String details = guide.getDetails();
        String email = guide.getEmail();

        assertEquals(1L, id);
        assertEquals("Pepe", name);
        assertEquals("Madrid", destination);
        assertEquals("I am a guide", details);
        assertEquals("pepe@domain.com", email);
    }

}
