package com.studentCourceManagement.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentCourceManagement.Excetion.ExcetionHandler;
import com.studentCourceManagement.entity.Course;
import com.studentCourceManagement.entity.Student;
import com.studentCourceManagement.repository.CourseRepository;
import com.studentCourceManagement.service.CourseService;

@Service
public class CourseServiceimpl implements CourseService  {
 @Autowired
	private CourseRepository courserepo;
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public List<Course> getAvailableCourses() {
		
		return courserepo.findAvailabelCourses();
	}

	@Override
	public Set<Student> getCourseforStudent(int couseid) {
		Optional<Course> course = courserepo.findById(couseid);
		if (course.isPresent()) {
			return course.get().getStudent();

		} else {
			throw new ExcetionHandler("course not found");
		}

	}
 
	
	
}
