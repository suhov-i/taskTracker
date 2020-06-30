package com.epam.testtask.repository.jpa;

import com.epam.testtask.model.User;
import com.epam.testtask.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserJPARepository implements UserRepository {

    private EntityManager em;

    @Autowired
    public UserJPARepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user;
    }

    @Override
    public User get(int id) {
        Session session = em.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery("delete from User where id=:theId");
        query.setParameter("theId", id);
        return query.executeUpdate() == 1;
    }

    @Override
    public List<User> getAll() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from User", User.class).getResultList();
    }
}
