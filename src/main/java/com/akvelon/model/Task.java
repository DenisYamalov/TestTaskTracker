package com.akvelon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tasks", schema = "tracker")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "t_priority", nullable = false)
    private int priority;

    @Column(name = "task_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    public Task() {

    }
    @JsonCreator
    public Task(long id, String name, String description, int priority, TaskStatus taskStatus, Project project) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.project = project;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Project getProject() {

        return project;
    }

    public void setProject(Project project) {

        this.project = project;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getPriority() {

        return priority;
    }

    public void setPriority(int priority) {

        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {

        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {

        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (getId() != task.getId()) return false;
        if (getPriority() != task.getPriority()) return false;
        if (!getName().equals(task.getName())) return false;
        if (!getDescription().equals(task.getDescription())) return false;
        if (getTaskStatus() != task.getTaskStatus()) return false;
        return getProject().equals(task.getProject());
    }

    @Override
    public int hashCode() {

        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getPriority();
        result = 31 * result + getTaskStatus().hashCode();
        result = 31 * result + getProject().hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
