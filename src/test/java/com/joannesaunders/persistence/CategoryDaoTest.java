package com.joannesaunders.persistence;

import com.joannesaunders.entity.Category;
import com.joannesaunders.entity.Category;
import com.joannesaunders.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Category dao test.
 */
class CategoryDaoTest {

    CategoryDao dao;

    /**
     * Create a CategoryDao
     */
    @BeforeEach
    void setUp() {
        com.joannesaunders.test.util.Database database = com.joannesaunders.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new CategoryDao();
    }

    /**
     * Gets all categories success.
     */
    @Test
    void getAllCategoriesSuccess() {
        List<Category> categories = dao.getAllCategories();
        assertEquals(5, categories.size());
    }

    /**
     * verifies a single category is returned based on the category ID sent in.
     */
    @Test
    void getByIdSuccess() {
        Category category = dao.getById(3);
        assertNotNull(category);
        assertEquals(3, category.getId());
        assertEquals("Salad", category.getDescription());
    }

    /**
     * Verify successful insert of a category
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Category newCategory = new Category("Bread", user);
        user.addCategory(newCategory);

        int id = dao.insert(newCategory);

        assertNotEquals(0,id);
        Category insertedCategory = dao.getById(id);
        assertEquals("Bread", insertedCategory.getDescription());
        assertEquals("joanne.saunders@hansonmanor.us", insertedCategory.getUser().getUserName());

    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }
    /**
     * Verify successful update of category
     */
    @Test
    void updateSuccess() {
        String description = "Meat";
        Category categoryToUpdate = dao.getById(3);
        categoryToUpdate.setDescription(description);
        dao.saveOrUpdate(categoryToUpdate);
        Category retrievedCategory = dao.getById(3);
        assertEquals(description, retrievedCategory.getDescription());

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> categories = dao.getByPropertyEqual("description", "Soup");
        assertEquals(1, categories.size());
        assertEquals(4, categories.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = dao.getByPropertyLike("description", "S");
        assertEquals(2, categories.size());
    }
}