package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items_tasks")
public class ItemsTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "element_qty")
    private Integer elementQty;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Integer getElementQty() {
		return elementQty;
	}

	public void setElementQty(Integer elementQty) {
		this.elementQty = elementQty;
	}

	public String getElementStatus() {
		return elementStatus;
	}

	public void setElementStatus(String elementStatus) {
		this.elementStatus = elementStatus;
	}

	public String getElementNote() {
		return elementNote;
	}

	public void setElementNote(String elementNote) {
		this.elementNote = elementNote;
	}

	@Column(name = "element_status")
    private String elementStatus;

    @Column(name = "element_note")
    private String elementNote;

    // Autres champs spécifiques à la relation "items_tasks" si nécessaire

    public ItemsTasks() {
    }

    public ItemsTasks(Item item, Task task, Integer elementQty, String elementStatus, String elementNote) {
        this.item = item;
        this.task = task;
        this.elementQty = elementQty;
        this.elementStatus = elementStatus;
        this.elementNote = elementNote;
    }

    // Getters and setters
    // ...
}
