package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;
    private User user;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        user = new User("Umut");
    }

    @Test
    public void testAddUser() {
        userManager.addUser(user);
        Optional<User> result = userManager.findByName("Umut");
        assertTrue(result.isPresent(), "Kullanici bulunamadi");
        assertEquals(user, result.get(), "Bulunan kullanici ile beklenen kullanici eslesmiyor");
    }

    @Test
    public void testFindByNameSuccess() {
        userManager.addUser(user);
        Optional<User> result = userManager.findByName("Umut");
        assertTrue(result.isPresent(), "Kullanici buluanmadi");
        assertEquals(user, result.get(), "findByName dogru kullaniciyi donduremedi");
    }

    @Test
    public void testFindByNameNotFound() {
        Optional<User> result = userManager.findByName("Umut");
        assertTrue(result.isEmpty(), "Kullanici eklenmemesine ragmen bulundu");
    }
}
