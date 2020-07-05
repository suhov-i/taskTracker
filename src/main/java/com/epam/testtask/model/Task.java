package com.epam.testtask.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "required")
    private User user;

    @OneToOne
    @JoinColumn(name = "project_id")
    @NotNull(message = "required")
    private Project project;

    @Column(name = "subject")
    @NotNull(message = "required")
    @Size(min = 1, message = "minimum of 1 character")
    private String subject;

    @Column(name = "priority")
    @Min(value = 1, message = "must be greater than or equal to 1")
    @Max(value = 10, message = "must be less than or equal to 10")
    @NotNull(message = "required")
    private Integer priority;

    @Column(name = "type")
    @NotNull(message = "required")
    @Size(min = 1, message = "minimum of 1 character")
    private String type;

    @Column(name = "description")
    @NotNull(message = "required")
    @Size(min = 1, message = "minimum of 1 character")
    private String description;

    public Task() {
    }

    public Task(User user, Project project, String subject, int priority, String type, String description) {
        this.user = user;
        this.project = project;
        this.subject = subject;
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
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
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
                ", Subject='" + subject + '\'' +
                ", priority=" + priority +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(user, task.user) &&
                Objects.equals(project, task.project) &&
                Objects.equals(subject, task.subject) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(type, task.type) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, project, subject, priority, type, description);
    }
}
