package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class OrganizationTest {

    private Organization organization;

    @BeforeEach
    void setUp() {
        organization = new Organization();
        organization.setId(1L);
        organization.setName("Test Organization");
        Address address = new Address();
        address.setStreet("123 Test St");
        address.setCity("Test City");
        address.setState("Test State");
        address.setZipCode("12345");
        organization.setAddress(address);
        organization.setInstitutionName("Test Institution");
        organization.setHeadquartersCountry("Test Country");
    }

    @Test
    void getId() {
        assertNotNull(organization.getId());
        assertEquals(1L, organization.getId());
    }

    @Test
    void getName() {
        assertNotNull(organization.getName());
        assertEquals("Test Organization", organization.getName());
    }

    @Test
    void getAddress() {
        assertNotNull(organization.getAddress());
        assertEquals("123 Test St", organization.getAddress().getStreet());
        assertEquals("Test City", organization.getAddress().getCity());
        assertEquals("Test State", organization.getAddress().getState());
        assertEquals("12345", organization.getAddress().getZipCode());
    }

    @Test
    void getInstitutionName() {
        assertNotNull(organization.getInstitutionName());
        assertEquals("Test Institution", organization.getInstitutionName());
    }

    @Test
    void getHeadquartersCountry() {
        assertNotNull(organization.getHeadquartersCountry());
        assertEquals("Test Country", organization.getHeadquartersCountry());
    }

    @Test
    void setId() {
        organization.setId(2L);
        assertEquals(2L, organization.getId());
    }

    @Test
    void setName() {
        organization.setName("New Organization");
        assertEquals("New Organization", organization.getName());
    }

    @Test
    void setAddress() {
        Address newAddress = new Address();
        newAddress.setStreet("456 New St");
        newAddress.setCity("New City");
        newAddress.setState("New State");
        newAddress.setZipCode("67890");
        organization.setAddress(newAddress);
        assertEquals("456 New St", organization.getAddress().getStreet());
        assertEquals("New City", organization.getAddress().getCity());
        assertEquals("New State", organization.getAddress().getState());
        assertEquals("67890", organization.getAddress().getZipCode());
    }

    @Test
    void setInstitutionName() {
        organization.setInstitutionName("New Institution");
        assertEquals("New Institution", organization.getInstitutionName());
    }

    @Test
    void setHeadquartersCountry() {
        organization.setHeadquartersCountry("New Country");
        assertEquals("New Country", organization.getHeadquartersCountry());
    }
}