package com.epam.testtask.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "subject")
    private String Subject;

    @Column(name = "priority")
    private int priority;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    //required by hibernate
    public Task() {
    }

    public Task(User user, Project project, String subject, int priority, String type, String description) {
        this.user = user;
        this.project = project;
        Subject = subject;
        this.priority = priority;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user=" + user +
                ", project=" + project +
                ", Subject='" + Subject + '\'' +
                ", priority=" + priority +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
