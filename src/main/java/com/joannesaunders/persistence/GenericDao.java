package com.joannesaunders.persistence;

import com.joannesaunders.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 * somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 * @param <T> the type parameter
 */


public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets an entity by Id.
     * @param id entity id to search by
     *
     * @return entity
     */
    public <T>T getById(int id){
        Session session = getSession();
        T entity = (T)session.get(type, id); // (T) casts the object to the correct type.
        session.close();
        return entity;
    }


    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
