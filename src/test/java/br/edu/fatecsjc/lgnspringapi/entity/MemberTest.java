package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberTest {

    private Member member;
    private Group group;

    @BeforeEach
    void setUp() {
        group = Group.builder().id(1L).name("Test Group").build();
        member = Member.builder()
                .id(1L)
                .name("John Doe")
                .age(30)
                .group(group)
                .build();
    }

    @Test
    void getId() {
        assertNotNull(member.getId());
        assertEquals(1L, member.getId());
    }

    @Test
    void getName() {
        assertNotNull(member.getName());
        assertEquals("John Doe", member.getName());
    }

    @Test
    void getAge() {
        assertNotNull(member.getAge());
        assertEquals(30, member.getAge());
    }

    @Test
    void getGroup() {
        assertNotNull(member.getGroup());
        assertEquals(group, member.getGroup());
    }

    @Test
    void setId() {
        member.setId(2L);
        assertEquals(2L, member.getId());
    }

    @Test
    void setName() {
        member.setName("Jane Doe");
        assertNotNull(member.getName());
        assertEquals("Jane Doe", member.getName());
    }

    @Test
    void setAge() {
        member.setAge(25);
        assertNotNull(member.getAge());
        assertEquals(25, member.getAge());
    }

    @Test
    void setGroup() {
        Group newGroup = Group.builder().id(2L).name("New Group").build();
        member.setGroup(newGroup);
        assertNotNull(member.getGroup());
        assertEquals(newGroup, member.getGroup());
    }
}

