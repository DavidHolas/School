package com.davidholas.TestApp.entities;

import java.time.LocalDateTime;

public class CourseResource {

    private Long id;

    private String name;

    private LocalDateTime beginning;

    private LocalDateTime end;

    public CourseResource(Long id, String name, LocalDateTime beginning, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.beginning = beginning;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
