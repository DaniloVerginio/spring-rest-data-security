package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupMemberTest {

    private GroupMember groupMember;
    private Organization organization;

    @BeforeEach
    void setUp() {
        organization = new Organization();
        organization.setId(1L);
        organization.setName("Test Organization");

        groupMember = new GroupMember();
        groupMember.setId(1L);
        groupMember.setOrganization(organization);
        groupMember.setName("Test Group Member");
    }

    @Test
    void getId() {
        assertNotNull(groupMember.getId());
        assertEquals(1L, groupMember.getId());
    }

    @Test
    void getOrganization() {
        assertNotNull(groupMember.getOrganization());
        assertEquals(1L, groupMember.getOrganization().getId());
        assertEquals("Test Organization", groupMember.getOrganization().getName());
    }

    @Test
    void getName() {
        assertNotNull(groupMember.getName());
        assertEquals("Test Group Member", groupMember.getName());
    }

    @Test
    void setId() {
        groupMember.setId(2L);
        assertEquals(2L, groupMember.getId());
    }

    @Test
    void setOrganization() {
        Organization newOrganization = new Organization();
        newOrganization.setId(2L);
        newOrganization.setName("New Organization");

        groupMember.setOrganization(newOrganization);
        assertNotNull(groupMember.getOrganization());
        assertEquals(2L, groupMember.getOrganization().getId());
        assertEquals("New Organization", groupMember.getOrganization().getName());
    }

    @Test
    void setName() {
        groupMember.setName("New Group Member");
        assertEquals("New Group Member", groupMember.getName());
    }
}
