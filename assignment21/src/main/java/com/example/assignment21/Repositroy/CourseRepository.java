package com.example.assignment21.Repositroy;

import com.example.assignment21.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
}
