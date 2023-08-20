package com.example.assignment21.Repositroy;

import com.example.assignment21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

Teacher findTeacherById(Integer id);
}
