package com.studentCourceManagement.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;
import com.studentCourceManagement.service.CourseService;

@RestController 
@RequestMapping("/course")
public class CourseController {
  @Autowired
	private CourseService courseservice;
@PostMapping("/savecourse")	
public Course saveCourse(@RequestBody   Course course) {
	return courseservice.saveCourse(course); 
	
} 
@GetMapping("/getAllAvailableCourses")
public List<Course> getavailablecourse() {
	return courseservice.getAvailableCourses(); 
	
	
}
@GetMapping("/{courseid}/course")
public Set<Student> getCourseForStudent(@PathVariable int courseid) {

	Set<Student> courses = courseservice.getCourseforStudent(courseid);

	return courses;

}


}
