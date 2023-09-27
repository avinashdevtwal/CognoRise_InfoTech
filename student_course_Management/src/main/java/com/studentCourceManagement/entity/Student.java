package com.studentCourceManagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	 
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_course_table",
	joinColumns =  @JoinColumn(name="student_id"), 
	inverseJoinColumns = @JoinColumn(name="cource_id")


	)
	
	Set<Course> course;

	public Student() {
		super();
	}

	public Student(int id, String name, Set<Course> course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}

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

	public Set<Course> getCource() {
		return course;
	}

	public void setCource(Set<Course> cource) {
		this.course = cource;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cource=" + course + "]";
	}

}
