package com.akvelon.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects", schema = "tracker")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_name", unique = true, nullable = false, length = 100)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "complete_date", nullable = false)
    private Date completeDate;

    @Column(name = "p_priority", nullable = false)
    private int priority;

    @Column(name = "project_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

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

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }

    public Date getCompleteDate() {

        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {

        this.completeDate = completeDate;
    }

    public int getPriority() {

        return priority;
    }

    public void setPriority(int priority) {

        this.priority = priority;
    }

    public ProjectStatus getProjectStatus() {

        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {

        this.projectStatus = projectStatus;
    }

    public List<Task> getTasks() {

        return tasks;
    }

    public void setTasks(List<Task> tasks) {

        this.tasks = tasks;
    }

    @Override
    public String toString() {

        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", completeDate=" + completeDate +
                ", priority=" + priority +
                ", projectStatus=" + projectStatus +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (getPriority() != project.getPriority()) return false;
        if (!getName().equals(project.getName())) return false;
        if (!getStartDate().equals(project.getStartDate())) return false;
        if (!getCompleteDate().equals(project.getCompleteDate())) return false;
        if (getProjectStatus() != project.getProjectStatus()) return false;
        return getTasks() != null ? getTasks().equals(project.getTasks()) : project.getTasks() == null;
    }

    @Override
    public int hashCode() {

        int result = getName().hashCode();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getCompleteDate().hashCode();
        result = 31 * result + getPriority();
        result = 31 * result + getProjectStatus().hashCode();
        result = 31 * result + (getTasks() != null ? getTasks().hashCode() : 0);
        return result;
    }
}
