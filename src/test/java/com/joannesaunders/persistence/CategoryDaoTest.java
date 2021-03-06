package com.joannesaunders.persistence;

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

    //CategoryDao dao;
    GenericDao genericDao;

    /**
     * Create a CategoryDao
     */
    @BeforeEach
    void setUp() {
        com.joannesaunders.test.util.Database database = com.joannesaunders.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        //dao = new CategoryDao();
        genericDao =  new GenericDao(Category.class);
    }

    /**
     * Gets all categories success.
     */
    @Test
    void getAllCategoriesSuccess() {
        List<Category> categories = genericDao.getAll();
        assertEquals(5, categories.size());
    }

    /**
     * verifies a single category is returned based on the category ID sent in.
     */
    @Test
    void getByIdSuccess() {
        Category category = (Category)genericDao.getById(3);
        assertNotNull(category);
        assertEquals(3, category.getId());
        assertEquals("Salad", category.getDescription());
    }

    /**
     * Verify successful insert of a category
     */
    @Test
    void insertSuccess() {

        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(1);
        Category newCategory = new Category("Bread", user);
        user.addCategory(newCategory);

        int id = genericDao.insert(newCategory);

        assertNotEquals(0,id);
        Category insertedCategory = (Category)genericDao.getById(id);
        assertEquals(newCategory, insertedCategory);
        assertEquals("joanne.saunders@hansonmanor.us", insertedCategory.getUser().getUserName());

    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(4));
        assertNull(genericDao.getById(4));
    }
    /**
     * Verify successful update of category
     */
    @Test
    void updateSuccess() {
        String description = "Meat";
        Category categoryToUpdate = (Category)genericDao.getById(3);
        categoryToUpdate.setDescription(description);
        genericDao.saveOrUpdate(categoryToUpdate);
        Category retrievedCategory = (Category)genericDao.getById(3);
        assertEquals(categoryToUpdate, retrievedCategory);

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> categories = genericDao.getByPropertyEqual("description", "Soup");
        assertEquals(1, categories.size());
        assertEquals(4, categories.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = genericDao.getByPropertyLike("description", "S");
        assertEquals(2, categories.size());
    }
}