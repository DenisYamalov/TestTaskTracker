package com.akvelon.controller;

import com.akvelon.dto.ProjectSortDto;
import com.akvelon.model.Project;
import com.akvelon.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Work with projects
 */
@RestController
public class ProjectController {

    @Autowired
    TrackerService trackerService;

    /**
     * Create new or edit existing project
     * @param project
     */
    @PostMapping("/editproject")
    public void editProject(@RequestBody Project project) {

        trackerService.addNewOrUpdateProject(project);
    }

    /**
     *
     * @param sortDto used to filter or sort projects by start date, complete date, priority
     * @return List of projects
     */
    @GetMapping("/projects")
    public List<Project> projectList(@RequestBody(required = false) ProjectSortDto sortDto) {

        if (sortDto != null) return trackerService.projectList(sortDto);
        return trackerService.projectList();
    }

    /**
     * Remove project and project tasks
     * @param project
     */
    @PostMapping("/deleteproject")
    public void deleteProject(@RequestBody Project project) {

        trackerService.deleteProject(project);
    }

}
