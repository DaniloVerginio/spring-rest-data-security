package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupMemberMarathonTest {

    private GroupMemberMarathon groupMemberMarathon;
    private GroupMember groupMember;
    private Marathon marathon;

    @BeforeEach
    void setUp() {
        groupMember = new GroupMember();
        groupMember.setId(1L);
        groupMember.setName("Test Group Member");

        marathon = new Marathon();
        marathon.setId(1L);
        marathon.setName("Test Marathon");

        groupMemberMarathon = new GroupMemberMarathon();
        groupMemberMarathon.setId(1L);
        groupMemberMarathon.setGroupMember(groupMember);
        groupMemberMarathon.setMarathon(marathon);
    }

    @Test
    void getId() {
        assertNotNull(groupMemberMarathon.getId());
        assertEquals(1L, groupMemberMarathon.getId());
    }

    @Test
    void getGroupMember() {
        assertNotNull(groupMemberMarathon.getGroupMember());
        assertEquals(1L, groupMemberMarathon.getGroupMember().getId());
        assertEquals("Test Group Member", groupMemberMarathon.getGroupMember().getName());
    }

    @Test
    void getMarathon() {
        assertNotNull(groupMemberMarathon.getMarathon());
        assertEquals(1L, groupMemberMarathon.getMarathon().getId());
        assertEquals("Test Marathon", groupMemberMarathon.getMarathon().getName());
    }

    @Test
    void setId() {
        groupMemberMarathon.setId(2L);
        assertEquals(2L, groupMemberMarathon.getId());
    }

    @Test
    void setGroupMember() {
        GroupMember newGroupMember = new GroupMember();
        newGroupMember.setId(2L);
        newGroupMember.setName("New Group Member");

        groupMemberMarathon.setGroupMember(newGroupMember);
        assertNotNull(groupMemberMarathon.getGroupMember());
        assertEquals(2L, groupMemberMarathon.getGroupMember().getId());
        assertEquals("New Group Member", groupMemberMarathon.getGroupMember().getName());
    }

    @Test
    void setMarathon() {
        Marathon newMarathon = new Marathon();
        newMarathon.setId(2L);
        newMarathon.setName("New Marathon");

        groupMemberMarathon.setMarathon(newMarathon);
        assertNotNull(groupMemberMarathon.getMarathon());
        assertEquals(2L, groupMemberMarathon.getMarathon().getId());
        assertEquals("New Marathon", groupMemberMarathon.getMarathon().getName());
    }
}

