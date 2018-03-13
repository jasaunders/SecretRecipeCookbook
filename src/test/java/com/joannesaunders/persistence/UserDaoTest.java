package com.joannesaunders.persistence;

import com.joannesaunders.entity.*;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    UserDao dao;

    /**
     * Create a UserDao
     */
    @BeforeEach
    void setUp() {
        com.joannesaunders.test.util.Database database = com.joannesaunders.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(7, users.size());
    }

    /**
     * Gets users by last name.
     */
    @Test
    void getUsersByLastName() {
        List<User> users = dao.getUsersByLastName("P");
        assertEquals(2, users.size());
    }

    /**
     * verifies a single user is returned based on the user ID sent in.
     */
    @Test
    void getByIdSuccess() {
        User user = dao.getById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Joanne", user.getFirstName());
        assertEquals("Saunders",user.getLastName());
        assertEquals("secret123$", user.getPassword());
        assertEquals("joanne.saunders@hansonmanor.us", user.getUserName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Trixie", "Bucket", "tbucket", "secret123$");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a user with category
     */
    @Test
    void insertWithCategorySuccess() {

        User newUser = new User("Trixie", "Bucket", "tbucket", "secret123$");

        String categoryDescription = "Salad";
        Category category = new Category(categoryDescription, newUser);

        newUser.addCategory(category);

        int id = dao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getCategories().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }

    @Test
    void updateSuccess() {
        String newLastName = "Pollick";
        User userToUpdate = dao.getById(4);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(4);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("lastName", "Diller");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "l");
        assertEquals(3, users.size());
    }
}