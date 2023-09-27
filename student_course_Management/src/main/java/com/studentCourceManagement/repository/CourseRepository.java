package com.studentCourceManagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentCourceManagement.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
  @Query("select c from Course c where c.capacity > SIZE(c.student )") 
	List<Course>findAvailabelCourses();
}
