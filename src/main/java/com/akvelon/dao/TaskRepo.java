package com.akvelon.dao;

import com.akvelon.model.Project;
import com.akvelon.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task, Long> {

    /**
     * @param project It can be just project Id : {"id": 1}
     * @return Project task list
     */
    List<Task> findByProject(Project project);

}
