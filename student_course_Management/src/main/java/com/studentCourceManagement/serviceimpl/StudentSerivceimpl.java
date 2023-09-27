package com.studentCourceManagement.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentCourceManagement.Excetion.ExcetionHandler;
import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;
import com.studentCourceManagement.repository.CourseRepository;
import com.studentCourceManagement.repository.StudentRepository;
import com.studentCourceManagement.service.StudentService;

@Service
public class StudentSerivceimpl implements StudentService {

	@Autowired(required = true)
	StudentRepository studentrepo;
	@Autowired(required = true)
	private CourseRepository courserepo;

	@Override
	public Student registerStudent(Student student) {
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getallStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public void registerStudentforCourse(int id, int courseid) {
		Optional<Student> student = studentrepo.findById(id);
		Optional<Course> course = courserepo.findById(courseid);
		if (course.get().getCapacity() > course.get().getStudent().size()) {
			student.get().getCource().add(course.get());
			studentrepo.save(student.get());
		} else {
			throw new ExcetionHandler("Course is already full");
		}
	}

	

	@Override
	public Optional<Student> getAllStudentWithCourses(int id) {

		return studentrepo.findById(id);
	}

	@Override
	public void removeRegisteCourse(int id, int courseid) {
		Student student = studentrepo.findById(id).orElseThrow(() -> new ExcetionHandler("id not found"));
		Course course = courserepo.findById(courseid).orElseThrow(() -> new ExcetionHandler("couse id not found"));
		student.getCource().remove(course);
		studentrepo.save(student);

	}

}