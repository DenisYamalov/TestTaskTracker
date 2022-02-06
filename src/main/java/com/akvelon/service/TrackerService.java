package com.akvelon.service;

import com.akvelon.dao.ProjectRepo;
import com.akvelon.dao.TaskRepo;
import com.akvelon.dto.ProjectSortDto;
import com.akvelon.dto.SortType;
import com.akvelon.exceptions.MyException;
import com.akvelon.model.Project;
import com.akvelon.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackerService {

    private final Logger log = LoggerFactory.getLogger(TrackerService.class);

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private TaskRepo taskRepo;

    /**
     * Add new or update project or project tasks
     *
     * @param project to be created  or updated
     */
    public void addNewOrUpdateProject(Project project) {

        log.info(project.toString());
        project.getTasks().forEach(t -> t.setProject(project));
        project.getTasks().forEach(t -> log.info("Project id = " + t.getProject().getId()));
        projectRepo.save(project);
    }

    /**
     * @return All projects
     */
    public List<Project> projectList() {

        return (List<Project>) projectRepo.findAll();
    }

    /**
     * Search project by Id
     *
     * @param id
     * @return Optional project
     */
    public Optional<Project> findProjectById(Long id) {

        return projectRepo.findById(id);
    }

    /**
     * @param sortDto to filter or order projects list
     * @return filtered or ordered projects list
     */
    public List<Project> projectList(ProjectSortDto sortDto) {

        if (sortDto.getSortType() == SortType.StartDateDesc) return projectRepo.findAllByOrderByStartDateDesc();
        if (sortDto.getSortType() == SortType.StartDateAsc) return projectRepo.findAllByOrderByStartDateAsc();
        if (sortDto.getSortType() == SortType.StartDate)
            return projectRepo.findAllByStartDate(sortDto.getReferenceDate());
        if (sortDto.getSortType() == SortType.CompleteDate)
            return projectRepo.findAllByCompleteDate(sortDto.getReferenceDate());
        if (sortDto.getSortType() == SortType.DateBetween)
            return projectRepo.findByStartDateBetween(sortDto.getReferenceDate(), sortDto.getEndPeriod());
        if (sortDto.getSortType() == SortType.DateAfter)
            return projectRepo.findByStartDateAfter(sortDto.getReferenceDate());
        if (sortDto.getSortType() == SortType.DateBefore)
            return projectRepo.findByStartDateBefore(sortDto.getReferenceDate());
        if (sortDto.getSortType() == SortType.PriorityDesc) return projectRepo.findAllByOrderByPriorityDesc();
        if (sortDto.getSortType() == SortType.PriorityAsc) return projectRepo.findAllByOrderByPriorityAsc();
        if (sortDto.getSortType() == SortType.PriorityGreaterThan)
            return projectRepo.findByPriorityGreaterThan(sortDto.getPriority());
        return projectList();
    }

    /**
     * Remove project and project tasks
     *
     * @param project It can be just project Id : {"id": 1}
     */
    public void deleteProject(Project project) {

        projectRepo.delete(project);
    }

    /**
     * @param project It can be just project Id : {"id": 1}
     * @return Project tasks list
     */
    public List<Task> taskList(Project project) {

        return taskRepo.findByProject(project);
    }

    /**
     * Add new or update task
     * @param task to be added or updated
     * @param projectId - Project Id
     * @throws MyException if there is no sych project with Project Id
     */
    public void addNewOrUpdateTask(Task task, long projectId) throws MyException {

        log.info("Project id = " + projectId);

        Optional<Project> project = projectRepo.findById(projectId);
        project.ifPresent(task::setProject);
        if (project.isEmpty()) throw new MyException("There is no project with  Id = " + projectId);
        taskRepo.save(task);
    }

    /**
     * Remove task
     * @param task It can be just task Id : {"id": 1}
     */
    public void deleteTask(Task task) {

        taskRepo.delete(task);
    }
}
