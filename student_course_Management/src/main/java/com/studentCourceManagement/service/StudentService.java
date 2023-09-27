package com.studentCourceManagement.service;




import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;
@Service
public interface StudentService {
 
	public Student registerStudent(Student student);
 
public List<Student>getallStudent();

public void registerStudentforCourse(int id,int courseid);  
public void removeRegisteCourse(int id ,int courseid);



public Optional<Student> getAllStudentWithCourses(int id);

}
