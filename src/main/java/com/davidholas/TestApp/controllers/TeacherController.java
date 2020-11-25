package com.davidholas.TestApp.controllers;

import com.davidholas.TestApp.entities.Teacher;
import com.davidholas.TestApp.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/teachers")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getTeachers() {

        List<Teacher> teachers = teacherService.getAllTeachers();

        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {

        Teacher teacher = teacherService.getTeacherById(id);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/addTeacher/{name}")
    public ResponseEntity addTeacher(@PathVariable String name) {

        teacherService.addTeacher(name);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {

        teacherService.deleteTeacher(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
