package com.davidholas.TestApp.services;

import com.davidholas.TestApp.entities.Teacher;
import com.davidholas.TestApp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {

        List<Teacher> teacher = teacherRepository.findAll();
        return teacher;
    }

    public Teacher getTeacherById(Long id) {

        Optional<Teacher> teacher = teacherRepository.findById(id);

        return teacher.get();
    }

    public void addTeacher(String name) {

        Teacher teacher = new Teacher(name);

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {

        teacherRepository.deleteById(id);
    }
}
