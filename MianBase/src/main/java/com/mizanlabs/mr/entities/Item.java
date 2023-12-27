package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_unit")
    private String itemUnit;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_note")
    private String itemNote;

    @ManyToMany
    @JoinTable(
            name = "items_tasks", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
            
    )
    @JsonIgnoreProperties("items")
    private Set<Task> tasks;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemNote() {
		return itemNote;
	}

	public void setItemNote(String itemNote) {
		this.itemNote = itemNote;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Item(Long itemId, String itemName, String itemUnit, BigDecimal itemPrice, String itemType, String itemNote,
			Set<Task> tasks) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemUnit = itemUnit;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemNote = itemNote;
		this.tasks = tasks;
	}


}
