package com.akvelon.controller;

import com.akvelon.exceptions.MyException;
import com.akvelon.model.Project;
import com.akvelon.model.Task;
import com.akvelon.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Work with tasks
 */
@RestController
public class TaskController {

    @Autowired
    TrackerService trackerService;

    /**
     * Create new or edit existing task
     * @param projectId project Id
     * @param task new or edited task
     * @throws MyException if no such project with project Id
     */
    @PostMapping("/edittask")
    public void editTask(@RequestParam long projectId, @RequestBody Task task) throws MyException {

        trackerService.addNewOrUpdateTask(task, projectId);
    }

    /**
     * Remove task
     * @param task
     */
    @PostMapping("/deletetask")
    public void deleteTask(@RequestBody Task task) {

        trackerService.deleteTask(task);
    }

    /**
     *
     * @param project It can be just project Id : {"id": 1}
     * @return Project task list
     */
    @GetMapping("/tasks")
    public List<Task> taskList(@RequestBody Project project) {

        return trackerService.taskList(project);
    }
}
