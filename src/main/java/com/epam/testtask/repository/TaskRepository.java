package com.epam.testtask.repository;

import com.epam.testtask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {

    //following methods with custom queries are for getting tasks by user or project

    @Query(value = "select * from Tasks t where t.project_id = :project", nativeQuery = true)
    List<Task> findByProject(@Param("project") int project);

    @Query(value = "select * from Tasks t where t.user_id = :user", nativeQuery = true)
    List<Task> findByUser(@Param("user") int user);
}
