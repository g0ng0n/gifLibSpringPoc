package com.test.project.giflib.dao;

import com.test.project.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gonzalo.gisbert on 25/04/17.
 */

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        // Open a session

        Session session = sessionFactory.openSession();

        // Get All categories with a Hibernate criteria
        List<Category> categories = session.createCriteria(Category.class).list();


        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {
        //Open session
        Session session = sessionFactory.openSession();

        // Begin trasanction
        session.beginTransaction();
        // save the cat
        session.save(category);

        // commit the transaction
        session.getTransaction().commit();
        // close session
        session.close();
    }

    @Override
    public void delete(Category category) {

    }
}
