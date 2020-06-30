package com.epam.testtask.repository.jpa;

import com.epam.testtask.model.Task;
import com.epam.testtask.repository.TaskRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class TaskJPARepository implements TaskRepository {

    private EntityManager em;

    @Autowired
    public TaskJPARepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Task save(Task task) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(task);
        return task;
    }

    @Override
    public Task get(int id) {
        Session session = em.unwrap(Session.class);
        return session.get(Task.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery("delete from Task where id=:theId");
        query.setParameter("theId", id);
        return query.executeUpdate() == 1;
    }

    @Override
    public List<Task> getAll() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Task ", Task.class).getResultList();
    }
}
