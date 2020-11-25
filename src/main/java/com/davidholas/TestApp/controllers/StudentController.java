package com.davidholas.TestApp.controllers;

import com.davidholas.TestApp.entities.Student;
import com.davidholas.TestApp.entities.StudentResource;
import com.davidholas.TestApp.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        Student student = studentService.getStudentbyId(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/addStudent/{name}")
    public ResponseEntity addStudent(@PathVariable String name) {

        if(!validateStudentName(name)) {
            return new ResponseEntity("Student name must be maximum 45 characters long.", HttpStatus.BAD_REQUEST);
        }

        studentService.addStudent(name);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("upgradeStudent")
    public ResponseEntity upgradeStudent(@RequestBody StudentResource studentResource) {

        studentService.upgradeStudent(studentResource);

        return new ResponseEntity(HttpStatus.OK);
    }

    public boolean validateStudentName(String name) {

        return name.length() <= 45;
    }
}
