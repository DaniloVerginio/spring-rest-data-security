package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarathonTest {

    private Marathon marathon;

    @BeforeEach
    void setUp() {
        marathon = new Marathon();
        marathon.setId(1L);
        marathon.setName("Test Marathon");
        marathon.setWeight(50);
        marathon.setScore(100);
    }

    @Test
    void getId() {
        assertNotNull(marathon.getId());
        assertEquals(1L, marathon.getId());
    }

    @Test
    void getName() {
        assertNotNull(marathon.getName());
        assertEquals("Test Marathon", marathon.getName());
    }

    @Test
    void getWeight() {
        assertEquals(50, marathon.getWeight());
    }

    @Test
    void getScore() {
        assertEquals(100, marathon.getScore());
    }

    @Test
    void setId() {
        marathon.setId(2L);
        assertEquals(2L, marathon.getId());
    }

    @Test
    void setName() {
        marathon.setName("New Marathon");
        assertNotNull(marathon.getName());
        assertEquals("New Marathon", marathon.getName());
    }

    @Test
    void setWeight() {
        marathon.setWeight(60);
        assertEquals(60, marathon.getWeight());
    }

    @Test
    void setScore() {
        marathon.setScore(120);
        assertEquals(120, marathon.getScore());
    }
}
