package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Temporal(TemporalType.DATE)
    @Column(name = "task_start")
    private Date taskStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "task_deadline")
    private Date taskDeadline;

    @Column(name = "task_priority")
    private String taskPriority;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "task_note")
    private String taskNote;

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnoreProperties("tasks")

    private Set<Item> items;

	public Task(Long taskId, String taskName, Date taskStart, Date taskDeadline, String taskPriority, String taskStatus,
			String taskNote, Set<Item> items) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStart = taskStart;
		this.taskDeadline = taskDeadline;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.taskNote = taskNote;
		this.items = items;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(Date taskStart) {
		this.taskStart = taskStart;
	}

	public Date getTaskDeadline() {
		return taskDeadline;
	}

	public void setTaskDeadline(Date taskDeadline) {
		this.taskDeadline = taskDeadline;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskNote() {
		return taskNote;
	}

	public void setTaskNote(String taskNote) {
		this.taskNote = taskNote;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

 
}
