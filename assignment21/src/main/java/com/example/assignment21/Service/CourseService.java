package com.example.assignment21.Service;

import com.example.assignment21.Api.ApiExeption;
import com.example.assignment21.Model.Course;
import com.example.assignment21.Model.Teacher;
import com.example.assignment21.Repositroy.CourseRepository;
import com.example.assignment21.Repositroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course){
        Course course1=courseRepository.findCourseById(id);
        if (course1==null){
            throw new ApiExeption("Course Id Not Found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);

    }

    public void deleteCourse(Integer id){
        Course course1=courseRepository.findCourseById(id);
        if (course1==null){
            throw new ApiExeption("Course Id Not Found");
        }
        courseRepository.delete(course1);
    }

    public void assignTeacherToCourse(Integer teacherId, Integer courseId){
        Teacher teacher =teacherRepository.findTeacherById(teacherId);
        Course course=courseRepository.findCourseById(courseId);

        if(teacher ==null || course==null){
            throw new ApiExeption("Can't assign");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getCourseById(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null || course.getTeacher() == null) {
            throw new ApiExeption("Course not found or no teacher assigned");
        }
        return course.getTeacher().getName();
    }
}
