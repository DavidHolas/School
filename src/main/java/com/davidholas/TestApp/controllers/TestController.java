package com.davidholas.TestApp.controllers;

import com.davidholas.TestApp.entities.Course;
import com.davidholas.TestApp.entities.Student;
import com.davidholas.TestApp.entities.Teacher;
import com.davidholas.TestApp.repositories.CourseRepository;
import com.davidholas.TestApp.repositories.StudentRepository;
import com.davidholas.TestApp.repositories.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    StudentRepository studentRepository;

    CourseRepository courseRepository;

    TeacherRepository teacherRepository;

    public TestController(StudentRepository studentRepository, CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/student_course/{studentId}/{courseId}")
    public void studentCourse(@PathVariable Long studentId, @PathVariable Long courseId) {

        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();

        student.addCourse(course);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    @GetMapping("teacher_course/{teacherId}/{courseId}")
    public void teacherCourse(@PathVariable Long teacherId, @PathVariable Long courseId) {

        Teacher teacher = teacherRepository.findById(teacherId).get();
        Course course = courseRepository.findById(courseId).get();

        course.setTeacher(teacher);
        teacher.getCourses().add(course);

        teacherRepository.save(teacher);
        courseRepository.save(course);
    }
}
