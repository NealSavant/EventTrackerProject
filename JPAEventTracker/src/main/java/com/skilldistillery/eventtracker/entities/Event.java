package com.skilldistillery.eventtracker.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "time_spent")
	private double timeSpent;

	private String date;

	// --------------------------
	public Event() {

	}

	public Event(int id, String name, double timeSpent, String date) {
		super();
		this.id = id;
		this.name = name;
		this.timeSpent = timeSpent;
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=").append(id).append(", name=").append(name).append(", timeSpent=").append(timeSpent)
				.append(", date=").append(date).append("]");
		return builder.toString();
	}

	// getters setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
