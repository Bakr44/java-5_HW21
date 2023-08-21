package com.example.assignment21.Controller;

import com.example.assignment21.Model.Course;
import com.example.assignment21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
            courseService.addCourse(course);
            return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
    return ResponseEntity.status(200).body("Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Deleted");
    }

    @PostMapping("/assign/{TeacherId}/To/{CourseId}")
    public ResponseEntity assignTeacherToCouse(@PathVariable Integer TeacherId, @PathVariable Integer CourseId ){
        courseService.assignTeacherToCourse(TeacherId, CourseId);
        return ResponseEntity.status(200).body("Assigned");
    }

    @GetMapping("/{courseId}/teacher")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer courseId) {
       return ResponseEntity.status(200).body("Teacher name for course with ID " + courseId + ": " +
               courseService.getCourseById(courseId));
    }

}
