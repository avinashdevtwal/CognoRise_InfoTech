package com.studentCourceManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;

@Service
public interface CourseService {
 
	public Course saveCourse(Course course); 
	 
	public List<Course> getAvailableCourses();
	 
	public Set<Student> getCourseforStudent(int courseid);
	
	
}
