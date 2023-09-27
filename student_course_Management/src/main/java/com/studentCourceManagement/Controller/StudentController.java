package com.studentCourceManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;
import com.studentCourceManagement.service.CourseService;
import com.studentCourceManagement.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired(required = true)
	StudentService studentservice;

	private CourseService courseservice;

	@PostMapping("/savestudent")
	public Student registration(@RequestBody Student studdent) {

		return studentservice.registerStudent(studdent);

	}

	@GetMapping("/getall")
	public List<Student> findallStudent() {
		return studentservice.getallStudent();

	}

	@PostMapping("/{id}/regi_course/{courseid}")
	public ResponseEntity<String> registercourse(@PathVariable int id, @PathVariable int courseid) {
		try {
			studentservice.registerStudentforCourse(id, courseid);
			return ResponseEntity.ok("course registration suceessfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("error for the registration" + e.getMessage());
		}
	}

	
	@GetMapping("/getstudent/{id}")
	public Optional<Student> getallstudentwithcourse(@PathVariable int id) {
		Optional<Student> student = studentservice.getAllStudentWithCourses(id);
		return student;

	}

	@PostMapping("/{id}/remove_course/{courseid}")
	public ResponseEntity<String> removeCourseRegisterByStudent(@PathVariable int id, @PathVariable int courseid) {
		try {
			studentservice.removeRegisteCourse(id, courseid);
			return ResponseEntity.ok("course remove succesfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("error for the remove course" + e.getMessage());
		}
	}

}
