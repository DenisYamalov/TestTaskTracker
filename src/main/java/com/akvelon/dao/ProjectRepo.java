package com.akvelon.dao;

import com.akvelon.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepo extends CrudRepository<Project, Long> {

    /**
     * @return Project list ordered by start date descending
     */
    List<Project> findAllByOrderByStartDateDesc();

    /**
     * @return Project list ordered by start date ascending
     */
    List<Project> findAllByOrderByStartDateAsc();

    /**
     * @param startDate
     * @return Project list with required start date
     */
    List<Project> findAllByStartDate(Date startDate);

    /**
     * @param completeDate
     * @return Project list with required complete date
     */
    List<Project> findAllByCompleteDate(Date completeDate);

    /**
     * @param startPeriod
     * @param endPeriod
     * @return Project list with start date between start period and end period
     */
    List<Project> findByStartDateBetween(Date startPeriod, Date endPeriod);

    /**
     * @param startDate
     * @return Project list starting after startDate
     */
    List<Project> findByStartDateAfter(Date startDate);

    /**
     * @param startDate
     * @return Project list starting before startDate
     */
    List<Project> findByStartDateBefore(Date startDate);

    /**
     * @return Project list ordered by priority descending
     */
    List<Project> findAllByOrderByPriorityDesc();

    /**
     * @return Project list ordered by priority ascending
     */
    List<Project> findAllByOrderByPriorityAsc();

    /**
     * @param priority
     * @return Project list with priority greater than required
     */
    List<Project> findByPriorityGreaterThan(Integer priority);

}
