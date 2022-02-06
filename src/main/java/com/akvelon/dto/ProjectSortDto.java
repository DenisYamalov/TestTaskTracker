package com.akvelon.dto;

import java.util.Date;

public class ProjectSortDto {
    private SortType sortType;
    private Date referenceDate;
    private Date endPeriod;
    private Integer priority;

    public ProjectSortDto() {

    }

    public ProjectSortDto(SortType sortType) {

        this.sortType = sortType;
    }

    public ProjectSortDto(SortType sortType, Date referenceDate) {

        this.sortType = sortType;
        this.referenceDate = referenceDate;
    }

    public ProjectSortDto(SortType sortType, Date referenceDate, Date endPeriod) {

        this.sortType = sortType;
        this.referenceDate = referenceDate;
        this.endPeriod = endPeriod;
    }

    public ProjectSortDto(SortType sortType, Integer priority) {

        this.sortType = sortType;
        this.priority = priority;
    }

    public SortType getSortType() {

        return sortType;
    }

    public void setSortType(SortType sortType) {

        this.sortType = sortType;
    }

    public Date getReferenceDate() {

        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {

        this.referenceDate = referenceDate;
    }

    public Date getEndPeriod() {

        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {

        this.endPeriod = endPeriod;
    }

    public Integer getPriority() {

        return priority;
    }

    public void setPriority(Integer priority) {

        this.priority = priority;
    }
}
