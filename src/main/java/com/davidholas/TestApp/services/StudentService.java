package com.davidholas.TestApp.services;

import com.davidholas.TestApp.entities.Course;
import com.davidholas.TestApp.entities.Student;
import com.davidholas.TestApp.entities.StudentResource;
import com.davidholas.TestApp.exceptions.AppBaseException;
import com.davidholas.TestApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@Service
@Transactional
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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
            student.setCredits(studentResource.getCredits());

            studentRepository.save(student);
        }
    }
}
