package com.studentCourceManagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseid;

	private String title;
	private String discribtion;
	private int capacity;
	private String schedule;

	public Course() {
		super();
	}

	@ManyToMany(mappedBy = "course")
	@JsonIgnore
	Set<Student> student;

	public Course(int courseid, String title, String discribtion, int capacity, String schedule, Set<Student> student) {
		super();
		this.courseid = courseid;
		this.title = title;
		this.discribtion = discribtion;
		this.capacity = capacity;
		this.schedule = schedule;
		this.student = student;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscribtion() {
		return discribtion;
	}

	public void setDiscribtion(String discribtion) {
		this.discribtion = discribtion;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + courseid + ", title=" + title + ", discribtion=" + discribtion + ", capacity=" + capacity
				+ ", schedule=" + schedule + ", student=" + student + "]";
	}

}
