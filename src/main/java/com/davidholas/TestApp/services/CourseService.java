package com.davidholas.TestApp.services;

import com.davidholas.TestApp.entities.Course;
import com.davidholas.TestApp.entities.CourseResource;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidholas.TestApp.repositories.CourseRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {

        List<Course> course = courseRepository.findAll();
        return course;
    }

    public Course getCourseById(Long id) {

        Optional<Course> course = courseRepository.findById(id);

        return course.get();
    }

    public void addCourse(CourseResource courseResource) {

        String name = courseResource.getName();
        LocalDateTime beginning = courseResource.getBeginning();
        LocalDateTime end = courseResource.getEnd();

        Course course = new Course(name, beginning, end);

        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {

        courseRepository.deleteById(id);
    }

    public void updateCourse(CourseResource courseResource) {

        Optional<Course> courseOpt = courseRepository.findById(courseResource.getId());

        if(courseOpt.isPresent()) {
            Course course = courseOpt.get();

            course.setName(course.getName());
            course.setBeginning(course.getBeginning());
            course.setEnd(course.getEnd());

            courseRepository.save(course);
        }
    }
}
