package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupTest {

    private Group group;
    private Member member1;
    private Member member2;
    private List<Member> members;

    @BeforeEach
    void setUp() {
        member1 = new Member();
        member1.setId(1L);
        member1.setName("Member 1");

        member2 = new Member();
        member2.setId(2L);
        member2.setName("Member 2");

        members = new ArrayList<>();
        members.add(member1);
        members.add(member2);

        group = Group.builder()
                .id(1L)
                .name("Test Group")
                .members(members)
                .build();
    }

    @Test
    void getId() {
        assertNotNull(group.getId());
        assertEquals(1L, group.getId());
    }

    @Test
    void getName() {
        assertNotNull(group.getName());
        assertEquals("Test Group", group.getName());
    }

    @Test
    void getMembers() {
        assertNotNull(group.getMembers());
        assertEquals(2, group.getMembers().size());
        assertEquals("Member 1", group.getMembers().get(0).getName());
        assertEquals("Member 2", group.getMembers().get(1).getName());
    }

    @Test
    void setId() {
        group.setId(2L);
        assertEquals(2L, group.getId());
    }

    @Test
    void setName() {
        group.setName("New Group Name");
        assertEquals("New Group Name", group.getName());
    }

    @Test
    void setMembers() {
        Member member3 = new Member();
        member3.setId(3L);
        member3.setName("Member 3");
        List<Member> newMembers = new ArrayList<>();
        newMembers.add(member3);

        group.setMembers(newMembers);
        assertEquals(1, group.getMembers().size());
        assertEquals("Member 3", group.getMembers().get(0).getName());
    }

    @Test
    void testToString() {
        String expected = "Group(id=1, name=Test Group, members=[Member(id=1, name=Member 1), Member(id=2, name=Member 2)])";
        assertEquals(expected, group.toString());
    }

    @Test
    void testAllArgsConstructor() {
        Group newGroup = new Group(2L, "New Group", new ArrayList<>());
        assertEquals(2L, newGroup.getId());
        assertEquals("New Group", newGroup.getName());
        assertNotNull(newGroup.getMembers());
    }

    @Test
    void testNoArgsConstructor() {
        Group newGroup = new Group();
        assertNotNull(newGroup);
    }

    @Test
    void testBuilder() {
        Group newGroup = Group.builder()
                .id(3L)
                .name("Built Group")
                .members(new ArrayList<>())
                .build();

        assertEquals(3L, newGroup.getId());
        assertEquals("Built Group", newGroup.getName());
        assertNotNull(newGroup.getMembers());
    }
}
