package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String exercise;
	private int sets;
	private int weight;
	private int reps;
	private String Status; 
	private String note;
	
	@ManyToOne
	private User user;

	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exercise(int id, String exercise, int sets, int weight, int reps, String status, String note, User user) {
		super();
		this.id = id;
		this.exercise = exercise;
		this.sets = sets;
		this.weight = weight;
		this.reps = reps;
		this.Status = status;
		this.note = note;
		this.user = user;
	}

	public Exercise(String exercise, int sets, int weight, int reps, String status, String note, User user) {
		super();
		this.exercise = exercise;
		this.sets = sets;
		this.weight = weight;
		this.reps = reps;
		this.Status = status;
		this.note = note;
		this.user = user;
	}
	
	public Exercise(int id,String exercise, int sets, int weight, int reps, String status, String note) {
		super();
		this.id=id;
		this.exercise = exercise;
		this.sets = sets;
		this.weight = weight;
		this.reps = reps;
		this.Status = status;
		this.note = note;
	}

}
