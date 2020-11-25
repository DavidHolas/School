package com.davidholas.TestApp.services;

import com.davidholas.TestApp.entities.Student;
import com.davidholas.TestApp.entities.StudentResource;
import com.davidholas.TestApp.exceptions.AppBaseException;
import com.davidholas.TestApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentbyId(Long id) {

        Optional<Student> student = studentRepository.findById(id);

        return student.get();
    }

    public void addStudent(String name) {

        Student student = new Student(name);

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public void upgradeStudent(StudentResource studentResource) {

        Optional<Student> studentOpt = studentRepository.findById(studentResource.getId());

        if(studentOpt.isPresent()) {
            Student student = studentOpt.get();

            student.setName(studentResource.getName());

            studentRepository.save(student);
        }
    }
}
