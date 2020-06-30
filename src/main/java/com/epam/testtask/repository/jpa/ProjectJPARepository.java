package com.epam.testtask.repository.jpa;

import com.epam.testtask.model.Project;
import com.epam.testtask.model.User;
import com.epam.testtask.repository.ProjectRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProjectJPARepository implements ProjectRepository {

    private EntityManager em;

    @Autowired
    public ProjectJPARepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Project save(Project project) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(project);
        return project;
    }

    @Override
    public Project get(int id) {
        Session session = em.unwrap(Session.class);
        return session.get(Project.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery("delete from Project where id=:theId");
        query.setParameter("theId", id);
        return query.executeUpdate() == 1;
    }

    @Override
    public List<Project> getAll() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Project", Project.class).getResultList();
    }
}
