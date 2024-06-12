package br.edu.fatecsjc.lgnspringapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.edu.fatecsjc.lgnspringapi.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("password")
                .role(Role.USER)
                .build();
    }

    @Test
    void getId() {
        assertNotNull(user.getId());
        assertEquals(1L, user.getId());
    }

    @Test
    void getFirstName() {
        assertNotNull(user.getFirstName());
        assertEquals("John", user.getFirstName());
    }

    @Test
    void getLastName() {
        assertNotNull(user.getLastName());
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void getEmail() {
        assertNotNull(user.getEmail());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void getPassword() {
        assertNotNull(user.getPassword());
        assertEquals("password", user.getPassword());
    }

    @Test
    void getRole() {
        assertNotNull(user.getRole());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    void getAuthorities() {
        assertNotNull(user.getAuthorities());
        assertEquals(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")), user.getAuthorities());
    }

    @Test
    void getUsername() {
        assertNotNull(user.getUsername());
        assertEquals("john.doe@example.com", user.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        assertEquals(true, user.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertEquals(true, user.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertEquals(true, user.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        assertEquals(true, user.isEnabled());
    }
}