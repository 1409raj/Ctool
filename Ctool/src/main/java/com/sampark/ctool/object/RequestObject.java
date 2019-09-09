package com.sampark.ctool.object;

import java.util.Date;

public class RequestObject {

	private Integer employeeId;
	private Integer projectId;
	private Date date;
	private Integer taskId;
	private Double spentHours;
	private String comments;
	
	public RequestObject() {
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Double getSpentHours() {
		return spentHours;
	}

	public void setSpentHours(Double spentHours) {
		this.spentHours = spentHours;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
