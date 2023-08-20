package com.example.assignment21.Service;

import com.example.assignment21.Api.ApiExeption;
import com.example.assignment21.Model.Address;
import com.example.assignment21.Model.Teacher;
import com.example.assignment21.Repositroy.AddressRepositroy;
import com.example.assignment21.Repositroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

private final TeacherRepository teacherRepository;
private final AddressRepositroy addressRepositroy;

public List<Teacher> getAllTeacher(){
    return teacherRepository.findAll();
}

public void addTeacher(Teacher teacher){
    teacherRepository.save(teacher);
}

public void updateTeacher(Integer id, Teacher teacher){
    Teacher teacher1=teacherRepository.findTeacherById(id);

    if (teacher1==null){
        throw new ApiExeption("ID Not Found");
    }
    teacher1.setName(teacher.getName());
    teacher1.setAge(teacher.getAge());
    teacher1.setEmail(teacher.getEmail());
    teacher1.setSalary(teacher.getSalary());
    teacherRepository.save(teacher1);
}

    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiExeption("ID Not Found");
        }
        addressRepositroy.deleteById(id);
        teacherRepository.delete(teacher1);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiExeption("Teacher not found");
        }
        return teacher;
    }

}
