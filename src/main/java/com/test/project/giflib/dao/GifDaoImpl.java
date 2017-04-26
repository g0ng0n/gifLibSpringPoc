package com.test.project.giflib.dao;

import com.test.project.giflib.model.Category;
import com.test.project.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by g0ng0n.
 */
@Repository
public class GifDaoImpl implements GifDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Gif> findAll() {
        // Open a session

        Session session = sessionFactory.openSession();

        // Get All categories with a Hibernate criteria
        List<Gif> gifs = session.createCriteria(Gif.class).list();


        session.close();

        return gifs;
    }

    @Override
    public Gif findById(Long id) {
        Session session = sessionFactory.openSession();

        Gif gif = session.get(Gif.class, id);

        session.close();

        return gif;
    }

    @Override
    public void save(Gif gif) {
        //Open session
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(gif);

        session.getTransaction().commit();
        // close session
        session.close();

    }

    @Override
    public void delete(Gif gif) {

        //Open session
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.delete(gif);

        session.getTransaction().commit();
        // close session
        session.close();

    }
}
