package com.davidholas.TestApp.controllers;

import com.davidholas.TestApp.entities.Course;
import com.davidholas.TestApp.entities.CourseResource;
import com.davidholas.TestApp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getCourses() {

        List<Course> courses = courseService.getAllCourses();

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {

        Course course = courseService.getCourseById(id);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/addCourse/")
    public ResponseEntity addCourse(@RequestBody CourseResource courseResource) {

        courseService.addCourse(courseResource);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateCourse(@RequestBody CourseResource courseResource) {

        courseService.updateCourse(courseResource);

        return new ResponseEntity(HttpStatus.OK);
    }
}
