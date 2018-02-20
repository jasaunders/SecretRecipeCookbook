package com.joannesaunders.persistence;

import com.joannesaunders.entity.Category;
import com.joannesaunders.persistence.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all categories.
     *
     * @return all categories
     */
    public List<Category> getAllCategories() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        List<Category> categories = session.createQuery(query).getResultList();
        session.close();
        return categories;
    }

    /**
     * Gets categories based on search of description.
     *
     * @return the all categories
     */
    public List<Category> getCategoriesByDescription(String description) {

        logger.debug("Searching for category: {}", description);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        Expression<String> propertyPath = root.get("description");
        query.where(builder.like(propertyPath, "%" + description + "%"));
        List<Category> categories = session.createQuery(query).getResultList();
        session.close();
        return categories;


    }

    /**
     * Gets a category based on search of Id.
     *
     * @return a single category
     */
    public Category getById(int id){
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id); // gets the whole category object
        session.close();
        return category;
    }

    /**
     * update category
     * @param category  Category to be inserted or updated
     */
    public void saveOrUpdate(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(category);
        transaction.commit();
        session.close();
    }

    /**
     * update category
     * @param category  Category to be inserted or updated
     */
    public int insert(Category category) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(category);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a category
     * @param category Category to be deleted
     */
    public void delete(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(category);
        transaction.commit();
        session.close();
    }

    /**
     * Get category by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Category> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for category with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Category> categorys = session.createQuery(query).getResultList();

        session.close();
        return categorys;
    }

    /**
     * Get category by property (like)
     * sample usage: getByPropertyLike("description", "C")
     */
    public List<Category> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for category with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery( Category.class );
        Root<Category> root = query.from( Category.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Category> categories = session.createQuery(query).getResultList();
        session.close();
        return categories;
    }

}

