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
    GenericDao genericDao;

    /**
     * Create a UserDao
     */
    @BeforeEach
    void setUp() {
        com.joannesaunders.test.util.Database database = com.joannesaunders.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
        genericDao = new GenericDao(User.class);
    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(7, users.size());
    }

    /**
     * Gets users by last name.
     * Remove when UI is converted to use the get by property method instead of get by last name
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
        User user = (User)genericDao.getById(1);
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
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
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

        int id = genericDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getCategories().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(4));
        assertNull(genericDao.getById(4));
    }

    @Test
    void updateSuccess() {
        String newLastName = "Pollick";
        User userToUpdate = (User)genericDao.getById(4);
        userToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(4);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("lastName", "Diller");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("lastName", "l");
        assertEquals(3, users.size());
    }
}