package com.akvelon.service;

import com.akvelon.model.Project;
import com.akvelon.model.ProjectStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TrackerServiceTest {

    @Autowired TrackerService trackerService;
    Project project = new Project();

    @BeforeAll
    void init(){

        project.setName(" Project name for testing");
        project.setStartDate(new Date());
        project.setCompleteDate(new GregorianCalendar(2022,2,20).getTime());
        project.setPriority(10);
        project.setProjectStatus(ProjectStatus.Active);
    }
    @Test
    void addNewProject() {
        trackerService.addNewOrUpdateProject(project);
        assertEquals(project.getName(),trackerService.findProjectById(project.getId()).get().getName());
        assertEquals(project.getStartDate(),trackerService.findProjectById(project.getId()).get().getStartDate());
        assertEquals(project.getCompleteDate(),trackerService.findProjectById(project.getId()).get().getCompleteDate());
        assertEquals(project.getPriority(),trackerService.findProjectById(project.getId()).get().getPriority());
        assertEquals(project.getProjectStatus(),trackerService.findProjectById(project.getId()).get().getProjectStatus());
        trackerService.deleteProject(project);
    }

    @Test
    void updateProject() {

    }

    @Test
    void projectList() {

    }

    @Test
    void testProjectList() {

    }

    @Test
    void deleteProject() {

    }

    @Test
    void taskList() {

    }

    @Test
    void addNewOrUpdateTask() {

    }

    @Test
    void deleteTask() {

    }
}