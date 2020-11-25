package com.davidholas.TestApp.services;

import com.davidholas.TestApp.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidholas.TestApp.repositories.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {

        List<Course> course = courseRepository.findAll();
        return course;
    }

    public Course getCourseById(Long id) {

        Optional<Course> course = courseRepository.findById(id);

        return course.get();
    }

    public void addCourse(String name) {

        Course course = new Course(name);

        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {

        courseRepository.deleteById(id);
    }
}
