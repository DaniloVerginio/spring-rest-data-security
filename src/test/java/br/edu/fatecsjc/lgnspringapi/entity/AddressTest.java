package br.edu.fatecsjc.lgnspringapi.entity;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
        address.setNumber("123");
        address.setStreet("Test Street");
        address.setNeighborhood("Test Neighborhood");
        address.setZipCode("12345");
        address.setCity("Test City");
        address.setState("Test State");
    }

    @Test
    void getNumber() {
        assertNotNull(address.getNumber());
        assertEquals("123", address.getNumber());
    }

    @Test
    void getStreet() {
        assertNotNull(address.getStreet());
        assertEquals("Test Street", address.getStreet());
    }

    @Test
    void getNeighborhood() {
        assertNotNull(address.getNeighborhood());
        assertEquals("Test Neighborhood", address.getNeighborhood());
    }

    @Test
    void getZipCode() {
        assertNotNull(address.getZipCode());
        assertEquals("12345", address.getZipCode());
    }

    @Test
    void getCity() {
        assertNotNull(address.getCity());
        assertEquals("Test City", address.getCity());
    }

    @Test
    void getState() {
        assertNotNull(address.getState());
        assertEquals("Test State", address.getState());
    }

    @Test
    void setNumber() {
        address.setNumber("456");
        assertEquals("456", address.getNumber());
    }

    @Test
    void setStreet() {
        address.setStreet("New Street");
        assertEquals("New Street", address.getStreet());
    }

    @Test
    void setNeighborhood() {
        address.setNeighborhood("New Neighborhood");
        assertEquals("New Neighborhood", address.getNeighborhood());
    }

    @Test
    void setZipCode() {
        address.setZipCode("67890");
        assertEquals("67890", address.getZipCode());
    }

    @Test
    void setCity() {
        address.setCity("New City");
        assertEquals("New City", address.getCity());
    }

    @Test
    void setState() {
        address.setState("New State");
        assertEquals("New State", address.getState());
    }
}
